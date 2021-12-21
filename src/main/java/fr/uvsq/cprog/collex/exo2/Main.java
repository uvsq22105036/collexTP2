package fr.uvsq.cprog.collex.exo2;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args){
        System.out.println("#######Shell Drawing######");
        UI userinterface = new UI();
        File fichier = new File("/Users/theobruant/Desktop/DESSIN_JAVA/figures.ser");
        if (fichier.length()!=0){
            System.out.println("Sauvegarde détéctée ! Reprise de l'ancienne sauvegarde ! ");
            userinterface.getFigure_saved();
        }
        while(true){
            userinterface.read();
        }
    }
}