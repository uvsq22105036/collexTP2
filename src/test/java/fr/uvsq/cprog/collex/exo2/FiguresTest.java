package fr.uvsq.cprog.collex.exo2;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class FiguresTest {
    Rectangle r = new Rectangle(new Point(0,0),new Point(5,5));
    Cercle c = new Cercle(new Point(0,0),5);
    @Test
    public void TestRectangle() throws Exception
    {
        assertEquals("Rectangle : ("+r.get_bg().toString()+","+r.get_hd().toString()+")","Rectangle : ((0,0),(5,5))");
    }
    @Test
    public void TestCercle() throws Exception
    {
        assertEquals("Cercle / centre : "+c.getCentre().toString()+"| rayon : "+Integer.toString(c.getRayon()),"Cercle / centre : (0,0)| rayon : 5");
    }
    @Test
    public void rec_move() throws Exception
    {
        r.move(2,2);
        assertEquals(r.get_bg().toString(),"(2,2)");
        assertEquals(r.get_hd().toString(),"(7,7)");
    }
    @Test
    public void circle_move() throws Exception
    {
        c.move(2,2);
        assertEquals(c.getCentre().toString(),"(2,2)");
    }
    

}