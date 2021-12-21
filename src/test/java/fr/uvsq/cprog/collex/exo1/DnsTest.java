package fr.uvsq.cprog.collex.exo1;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class DnsTest{ 
    AdresseIP ip = new AdresseIP("192.168.1.1");
    NomMachine machine = new NomMachine("PC1.uvsq.fr");
    Dns dns = new Dns(); 
    @Test
    public void TestGetItem() throws Exception{
        dns.initdb();
        assertEquals(dns.getItem(ip).getMachine().toString(),machine.toString());
    }
    @Test
    public void TestGetItem2() throws Exception{
        dns.initdb();
        assertEquals(dns.getItem(machine).getIp().toString(),ip.toString());
    }
    @Test
    public void TestGetItems() throws Exception {
        dns.initdb();
        
        DnsItem item1 = new DnsItem(new AdresseIP("108.177.16.0"),new NomMachine("PC1.google.local"));
        DnsItem item2 = new DnsItem(new AdresseIP("108.177.16.2"),new NomMachine("PC2.google.local"));
        DnsItem item3 = new DnsItem(new AdresseIP("108.177.16.3"),new NomMachine("Smartphone1.google.local"));
        List<DnsItem> result = new ArrayList<DnsItem>();
        result.add(item2);
        result.add(item3);
        result.add(item1);
        List<DnsItem> get = dns.getItems("google");
        for (int i=0;i<get.size();i++)
        {
            assertEquals(get.get(i).toString(),result.get(i).toString());
        }

    }
}