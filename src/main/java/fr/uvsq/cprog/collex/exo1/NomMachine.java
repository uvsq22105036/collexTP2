package fr.uvsq.cprog.collex.exo1;

import java.io.*;
public class NomMachine {
    private String Nommachine;
    public NomMachine(String Nommachine)
    {
        this.Nommachine = Nommachine;
    }
    public void print(){
        System.out.print("Machine : "+Nommachine);
    }
    @Override
    public String toString()
    {
        return Nommachine;
    }
    public String getDomain()
    {
        String[] parsing = this.Nommachine.split("\\.");
        return parsing[1];
    }
}
