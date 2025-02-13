import java.util.*;
public class Tour 
{
    Node head;
    int size;
    private class Node
    {
        Point p;
        Node next;
        
        public Node(Point p)
        {
            this.p = p;
        }
        public Node(Point p, Node x)
        {
            this.p=p;
            next  =x;
        }
    }
    
    
    /** create an empty tour */
    public Tour()
    {
        head=null;
        size=0;
    }
    
    /** create a four-point tour, for debugging */
    public Tour(Point a, Point b, Point c, Point d)
    {
        head = new Node(a);
        Node Pb = new Node(b);
        Node Pc = new Node(c);
        Node Pd = new Node(d);
        head.next = Pb.next = Pc.next = Pd.next = null;
        
    }
    
    /** print tour (one point per line) to std output */
    public void show()
    {
        Node temp = head;
        while(head.next!=null)
        {
            System.out.println(temp.toString());
            temp = temp.next;
        }
        
    }
    
    /** draw the tour using StdDraw */
    public void draw()
    {
        //StdDraw.setXscale(0, 600);
        //StdDraw.setYscale(0, 600);
        Node temp = head;
       
        for(int i =0; i<size; i++)
        {
            temp.p.drawTo(temp.next.p);
            temp = temp.next;
        }
    }
    
    /** return number of nodes in the tour */
    public int size()
    {
        //TODO
        
        return size;
    }
    
    /** return the total distance "traveled", from start to all nodes and back to start */
    public double distance()
    {
        //TODO
        Node temp = head;
        int sum = 0;
        while(temp.next!= null){
        sum += temp.p.distanceTo(temp.p);
        temp = temp.next;
    }
        return sum;
    }
    
    /** insert p using nearest neighbor heuristic */
    public void insertNearest(Point p) 
    {
        Node temp = head;
        double total = 0;
        int small =0;
        if(head==null)
        {
            head = new Node(p);
            
        }
        if(head.next==null)
        {
            head.next = new Node(p);
        }
        
        for(int i=0; i<size; i++)
        {
            if(temp.p.distanceTo(p) < total)
            {
                total = temp.p.distanceTo(p);
                small =i;
            }
            temp = temp.next;
        }
        temp=head;
        for(int s = 0; s<=small; s++)
        {
            temp=temp.next;
        }
        
        
        Node n = temp.next;
        temp.next = new Node(p,n);
        
        size++;
    }

    /** insert p using smallest increase heuristic */
    public void insertSmallest(Point p) 
    {
        //TODO
        Node temp = head;
        double total = 0;
        int small =0;
        if(head==null)
        {
            head = new Node(p);
            
        }
        if(head.next==null)
        {
            head.next = new Node(p);
        }
        
        for(int i = 0; i<size; i++)
        {
            Node x = temp.next;
            if(temp.p.distanceTo(p)<total)
            {
                total = temp.p.distanceTo(p);
                small = i;
            }
            temp.next = x;
            temp = temp.next;
        }
        
        for(int s = 0; s<=small; s++)
        {
            temp=temp.next;
        }
        
        
        Node n = temp.next;
        temp.next = new Node(p,n);
        
        size++;
    }
    
    
    public static void main(String[] args)
    {
        Point a = new Point (100.0, 100.0);
        Point b = new Point (500.0, 100.0);
        Point c = new Point (500.0, 500.0);
        Point d = new Point (100.0, 500.0);
        
        Tour squareTour = new Tour(a,b,c,d);
        
        squareTour.show();
    }
}