package fr.uvsq.cprog.collex.exo1;

import java.util.*;
import java.io.*;
public class DnsTUI {
    private Commande cmd;
    public DnsTUI()
    {
        this.cmd = new Commande();
    }
    public void nextCommande(String cmd){
        int point = 0;
        for(int i=0;i<cmd.length();i++)
        {
            char c = cmd.charAt(i);
            if (c=='.')
                point ++;
        }
        if (point == 2) //Machine
        {
            this.cmd = new Commande(cmd,"machineip");
            System.out.println(this.cmd.execute());
        }
        else if(point ==3) //IP
        {
            this.cmd = new Commande(cmd,"ipmachine");
            System.out.println(this.cmd.execute());
        }
        else if(cmd.contains("ls"))
        {
            String domaine = cmd.split(" ")[1];
            this.cmd = new Commande(domaine,"ls");
            System.out.println(this.cmd.execute());
        }
        else if(cmd.equals("q"))
        {
            System.exit(0);
        }
        else {
            System.out.println("Commande introuvable.");
        }
    }

}