package fr.uvsq.cprog.collex.exo1;
import java.io.*;
import java.util.*;
public class DnsApp {
    private DnsTUI tui;
    public DnsApp()
    {
        this.tui = new DnsTUI();
    }
    public static void main(String[] args)
    {
        DnsApp app = new DnsApp();
        while(true)
            app.run();
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        this.tui.nextCommande(cmd);
    }
}