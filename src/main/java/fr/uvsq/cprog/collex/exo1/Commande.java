package fr.uvsq.cprog.collex.exo1;
import java.util.*;
import java.io.*;
public class Commande {
    private String entry;
    private String arg;
    public Commande()
    {
        this.entry = "";
        this.arg = "";
    }
    public Commande(String entry, String arg)
    {
        this.entry = entry;
        this.arg = arg;
    }
    public String execute(){
        Dns dns = new Dns();
        dns.initdb();
        if (this.arg.equals("ipmachine"))//Conversion d'une IP en machine
        {
            AdresseIP ip = new AdresseIP(this.entry);
            DnsItem item = dns.getItem(ip);
            return item.getMachine().toString();
        } 
        else if (this.arg.equals("machineip"))//Conversion d'une machine en IP
        {
            NomMachine machine = new NomMachine(this.entry);
            DnsItem item = dns.getItem(machine);
            return item.getIp().toString();
        }
        else if(this.arg.equals("ls") || this.arg.equals("ls -a"))
        {
            List<DnsItem> items = dns.getItems(this.entry);
            String resultat = "";
            for (int i=0;i<items.size();i++)
            {
                if (items.get(i) instanceof DnsItem)
                {
                    resultat += items.get(i).toString();
                } 
            }
            return resultat;
        }
        else {
            return "Commande introuvable";
        }
    }
    public String getEntry()
    {
        return this.entry;
    }
    public String getArg(){
        return this.arg;
    }
}
