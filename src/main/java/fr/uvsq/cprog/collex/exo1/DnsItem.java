package fr.uvsq.cprog.collex.exo1;

public class DnsItem {
    private AdresseIP ip;
    private NomMachine machine;
    public DnsItem(AdresseIP ip, NomMachine machine)
    {
        this.ip = ip;
        this.machine = machine;
    }
    public String toString()
    {
        return ip.toString()+" | "+machine.toString()+"\n";
    }
    public void print()
    {
        if (this == null){
            System.out.println("Aucune entrée");
        }
        else {
            this.ip.print();
            System.out.print(" | ");
            this.machine.print();
            System.out.println();
        }
    }
    public AdresseIP getIp()
    {
        return this.ip;
    }
    public NomMachine getMachine()
    {
        return this.machine;
    }

}