package fr.uvsq.cprog.collex.exo2;

import java.util.*;
import java.io.*;
public class Point implements Serializable {
    private int X;
    private int Y;
    public Point(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }
    public void move(int dx, int dy)
    {
        this.X += dx;
        this.Y += dy;
    }
    public void print()
    {
        System.out.println("("+this.X+","+this.Y+")");
    }
    public String toString()
    {
        return "("+this.X+","+this.Y+")";
    }
    public int getX()
    {
        return this.X;
    }
    public int getY()
    {
        return this.Y;
    }
}