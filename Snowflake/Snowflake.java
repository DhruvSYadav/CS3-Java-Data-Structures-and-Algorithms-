import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
class SnowFlakePanel extends JPanel
{
    public SnowFlakePanel()
    {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }
    
    public void drawStar(Graphics g, int x, int y,int size)
    {
       
        //Line 1 
        g.drawLine(x, y, (int)(x + Math.cos(0) * size),(int)(y+Math.sin(0) * size));
        //L2
        g.drawLine(x, y, (int)(x + Math.cos(1 * (2*Math.PI)/6) * size),(int)(y+Math.sin(1 * (2 * Math.PI)/6) * size));
        //L3
        g.drawLine(x, y, (int)(x + Math.cos(2 * (2*Math.PI)/6) * size),(int)(y+Math.sin(2 * (2*Math.PI/6)) * size));
        //L4
        g.drawLine(x, y, (int)(x + Math.cos(3 * (2*Math.PI)/6) * size),(int)(y+Math.sin(3 * (2*Math.PI)/6) * size));
        //L5
        g.drawLine(x, y, (int)(x + Math.cos(4 * (2*Math.PI)/6) * size),(int)(y+Math.sin(4 * (2*Math.PI)/6) * size));
        //L6
        g.drawLine(x, y, (int)(x + Math.cos(5 * (2*Math.PI)/6) * size),(int)(y+Math.sin(5 * (2*Math.PI)/6) * size));
        
        drawStar(g,(int)(x + Math.cos(0) * size),(int)(y+Math.sin(0) * size),size);
        drawStar(g,(int)(x + Math.cos(1 * (2*Math.PI)/6) * size),(int)(y+Math.sin(1 * (2 * Math.PI)/6) * size),size);
        drawStar(g,(int)(x + Math.cos(2 * (2*Math.PI)/6) * size),(int)(y+Math.sin(2 * (2 * Math.PI)/6) * size),size);
        drawStar(g,(int)(x + Math.cos(3 * (2*Math.PI)/6) * size),(int)(y+Math.sin(3 * (2 * Math.PI)/6) * size),size);
        drawStar(g,(int)(x + Math.cos(4 * (2*Math.PI)/6) * size),(int)(y+Math.sin(4 * (2 * Math.PI)/6) * size),size);
        drawStar(g,(int)(x + Math.cos(5 * (2*Math.PI)/6) * size),(int)(y+Math.sin(5 * (2 * Math.PI)/6) * size),size);


       }
       
    public void recur(Graphics g, int x, int y, int size)
    {
           drawStar(g,x,y,size);
    }

    public void paintComponent(Graphics g)
    {
        int width  = getWidth();
        int height = getHeight();
        
        super.paintComponent(g);

        /*
         * DRAWING CODE BELOW
         */
        g.setColor(Color.BLUE);
        drawStar(g,(getWidth() + getHeight()) / 2,(getWidth() + getHeight()) / 2,getWidth()-100);
         
    }
}

public class Snowflake
{
    public static void main ( String[] args )
    {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }
}