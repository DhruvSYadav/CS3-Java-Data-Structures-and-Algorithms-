import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class Maze here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Maze
{
    // instance variables - replace the example below with your own
    private Square [][] Squares;
    private Square start;
    private Square end;
    

    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean loadMaze(String fileName)
    {
        Scanner input;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        Squares = new Square[input.nextInt()][input.nextInt()];
        for (int i = 0; i < Squares.length; i++) {
            for (int j = 0; j < Squares[0].length; j++) {
                Squares[i][j] = new Square(i, j, input.nextInt());
                if (Squares[i][j].getType() == Square.START) {
                    start = Squares[i][j];
                }
                if (Squares[i][j].getType() == Square.EXIT) {
                    end = Squares[i][j];
                }

            }
        }
        input.close();
        return true;
    }
 
    public List<Square> getNeighbors(Square s)
    {
        int row = s.getRow();
        int col = s.getCol();
        
        int neighbors = 0;
        ArrayList<Square> neighbor = new ArrayList<>();
        if (row>0)
        {
            neighbor.add(Squares[row-1][col]);
        }
        if (col<Squares[row].length - 1)
        {
           neighbor.add(Squares[row][col+1]); 
        }
        if(row<Squares.length-1)
        {
            neighbor.add(Squares[row+1][col]);
        }
        if(col>0)
        {
            neighbor.add(Squares[row][col-1]);
        }
        return neighbor;
    }
   
    public Square getStart()
    {
        return start;
    }
    
    public Square getExit()
    {
        return end;
    }
    
    public void reset()
    {
        for (int x =0; x<Squares.length; x++)
        {
            for(int y =0; y<Squares[0].length;y++)
            {
                Squares[x][y].reset();
            }
        }
    }
    
    public String toString()
    {
        String myString = "";
        for(int i =0; i<Squares.length; i++)
        {
            for(int x = 0; x<col; x++)
            {
                myString += Squares[i][x].toString();
            }
        }
        return myString;
    }
}