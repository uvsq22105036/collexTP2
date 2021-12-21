package fr.uvsq.cprog.collex.exo1;
import java.io.*;
import java.util.*;
public class Dns {
  private HashMap<AdresseIP,NomMachine> IptoMachine ;  
  private HashMap<NomMachine,AdresseIP> MachinetoIp;
  public Dns()
  {
    this.IptoMachine = new HashMap<AdresseIP,NomMachine>();
    this.MachinetoIp = new HashMap<NomMachine,AdresseIP>();
  }
  public void initdb()
  {
    try {
      FileInputStream db_file = new FileInputStream("/Users/theobruant/Desktop/collex-uvsq22105036/src/main/java/fr/uvsq/cprog/collex/exo1/BDD.txt");
      Scanner scanner = new Scanner(db_file).useDelimiter("\\s");
      while (scanner.hasNext())
      {
        NomMachine machine = new NomMachine(scanner.next());
        AdresseIP ip = new AdresseIP(scanner.next());
        this.IptoMachine.put(ip,machine);
        this.MachinetoIp.put(machine,ip);
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  public DnsItem getItem(AdresseIP ip)
  {
    for (Map.Entry<AdresseIP, NomMachine> element : this.IptoMachine.entrySet()) {
      if (element.getKey().toString().equals(ip.toString())){
        return new DnsItem(ip, element.getValue());
      }
    }
    return new DnsItem(ip,new NomMachine("Introuvable"));
  }
  public DnsItem getItem(NomMachine machine)
  {
    for (Map.Entry<NomMachine, AdresseIP> element : this.MachinetoIp.entrySet()) {
      if (element.getKey().toString().equals(machine.toString())){
        return new DnsItem(element.getValue(),machine);
      }
    }
    return new DnsItem(new AdresseIP("Introuvable"),machine);
  }
  public List<DnsItem> getItems(String domain)
  {
    List<DnsItem> result = new ArrayList<DnsItem>();
    int nb = 0;
    for (Map.Entry<NomMachine, AdresseIP> element : this.MachinetoIp.entrySet()) {
      if (element.getKey().getDomain().equals(domain)){
        result.add(new DnsItem(element.getValue(), element.getKey()));
        nb +=1;
      }
    }
    if (nb==0)
      return null;
    else 
      return result;
  }

}