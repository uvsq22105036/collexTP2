package fr.uvsq.cprog.collex.exo1;

import java.io.*;
public class AdresseIP {
    private String IP;
    public AdresseIP(String IP){
        this.IP = IP;
    }
    public void print()
    {
        System.out.print("Adresse IP : "+this.IP);
    }
    @Override
    public String toString()
    {
        return this.IP;
    }

}