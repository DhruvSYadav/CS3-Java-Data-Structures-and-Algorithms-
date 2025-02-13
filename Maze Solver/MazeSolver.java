import java.util.*;
public abstract class MazeSolver
{
    // instance variables - replace the example below with your own
    private Maze maze;
    private boolean solved = false;
    private boolean solvable = true;

    /**
     * Constructor for objects of class MazeSolver
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }
    
    //abstrract methods are just mwthods def you dont implement them yet
    public abstract void makeEmpty();
    //empty stack
    public abstract boolean isEmpty();
    //checks if stack empty
    public abstract void add(Square s);
    //add element to top of stack 
    public abstract Square next(); 

    public boolean isSolved()
    {
        // put your code here
        return solved;
    }
    
    public void step()
    {
        if(isEmpty())
        {
            solvable = false;
        }
        else 
        {
            Square next = next();
            if(next.getType()==Square.EXIT)
            {
                solved = true;
            }
            else
            {
                //check neighborrs to set explored, exploreing 
                List<Square> checkNeighbor = maze.getNeighbors(next);
                next.setStatus(Square.EXPLORED);
                for(int i =0; i<checkNeighbor.size(); i++)
                {
                    if(checkNeighbor.get(i).getType() == Square.EMPTY && checkNeighbor.get(i).getStatus() != Square.EXPLORED)
                    {
                        checkNeighbor.get(i).setStatus(Square.WORKING);
                        add(checkNeighbor.get(i));
                    }
                }
            }
        }
        
    }
    
    public String getPath()
    {
    if(solvable) { return "Maze is not solved";
    }
    if(solved) { return "Maze is solved"; 
    }
    return "Maze unsolvable";
    }
    
    public void solve()
    {
        while(!isSolved())
        {
            step();
        }
    }
}
    
    