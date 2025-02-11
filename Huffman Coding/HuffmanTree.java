import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Write a description of class HuffmanTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HuffmanTree
{

    // instance variables - replace the example below with your own
    public int x;
    int[] array;
    Node root;

    /**
     * Constructor for objects of class HuffmanTree
     */
    public HuffmanTree()
    {

    }

    
    public HuffmanTree(int[] counts)
    {
        int freq;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for( int i=0; i< counts.length; i++)
        {
            Node x = new Node();
            if(counts[i] > 0)
            {
                char let = (char) i; //gets the letter that i is 
                pq.add(i);
                
            }
            x.left = null;
            x.right = null;

        }
        Node root = null;

        while (pq.size() > 1)
        {
            Node x = pq.peek();
            pq.poll();

            Node y =pq.peek();
            pq.poll();

            Node combine = new Node();

            combine.weight = x.weight + y.weight;

            combine.left = x;
            combine.right = y;

            root = combine;

            pq.add(combine);
        }

    }

    public int compareTo(Node x, Node y)
    {
        return x.weight - y.weight;
    }

    public void write(String fileName)
    {
        // put your code here
        try{
            fileName = "input20.txt";
            File input = new File(fileName);
            try (Scanner tree = new Scanner(input)) {
                int count = 0;
                while(tree.hasNextLine())
                {
                    tree.nextLine();
                    count++;
                    int lines = count;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
    }

    public void encode(String filename)
    {
        int[] t = new int[256];
        try{
            Scanner s = new Scanner(new File(filename));
            while(s.hasNext()){
                String x = s.next();
                for(char c:x.toCharArray())
                {
                    t[c]++;
                }

            }
            HuffmanTree(t);
            write(filename + ".short");
        }
        catch (Exception ex){
            
        }

    }

    public HuffmanTree (String codeFile)
    {
        Queue<Node> fs = new LinkedList<>();
        try {
            root = null;
            Scanner scan = new Scanner(new File(codeFile));
            while(scan.hasNext()) {
                char letter = scan.nextLine().toCharArray()[0];
                int val = Integer.parseInt(scan.nextLine());
                Node k = new Node();
                if(root == null) root = k;
                else {
                    if(fs.peek().left == null) fs.peek().left = k;
                    else fs.peek().right = k;
                }
                fs.add(k);
            }
        } catch(Exception ex) {}
    }

    public void decode (BitInputStream in, String outFile)
    {
        try{
            PrintWriter output = new PrintWriter(new File(outFile));
            Node current = root;

            while(true)
            {
                int x = in.readBit();
                
                if(x==1)
                {
                    current = current.right;
                }
                else{
                    current = current.left;
                }

                if((int)current.c == 256)
                    break;

                else 
                output.write(current.c);

                current = root;
            }
        }

    }
}
