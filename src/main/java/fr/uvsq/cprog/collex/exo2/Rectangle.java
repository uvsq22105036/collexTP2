package fr.uvsq.cprog.collex.exo2;

import java.util.*;
import java.io.*;
public class Rectangle extends Figures  {
    private Point bas_gauche;
    private Point haut_droit;
    public Rectangle(Point bas_gauche, Point haut_droit)
    {
        this.bas_gauche = bas_gauche;
        this.haut_droit = haut_droit;
    }
    public void print()
    {
        System.out.println("Rectangle : ("+bas_gauche.toString()+","+haut_droit.toString()+")");
    }
    public void move(int dx, int dy)
    {
        this.bas_gauche.move(dx,dy);
        this.haut_droit.move(dx,dy);
    }
    public Point get_bg(){
        return this.bas_gauche;
    }
    public Point get_hd(){
        return this.haut_droit;
    }

} 