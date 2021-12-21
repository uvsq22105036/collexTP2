package fr.uvsq.cprog.collex.exo2;


import java.util.*;
import java.io.*;
public class Cercle extends Figures {
    private Point centre;
    private int rayon;
    public Cercle (Point centre, int rayon){
        this.centre = centre;
        this.rayon = rayon;
    }
    public void print()
    {
        System.out.println("Cercle / centre : "+centre.toString()+"| rayon : "+Integer.toString(rayon));
    }
    public void move(int dx,int dy)
    {
        this.centre.move(dx,dy);
    }
    public Point getCentre(){
        return this.centre;
    }
    public int getRayon(){
        return this.rayon;
    }
}