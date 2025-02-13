
/**
 * Write a description of class MazeSolverStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeSolverStack extends MazeSolver
{
    // instance variables - replace the example below with your own
    private MyStack Stack;

    /**
     * Constructor for objects of class MazeSolverStack
     */
    public MazeSolverStack(Maze maze)
    {
        // initialise instance variables
        super(maze);
    }

    public void makeEmpty()
    {
       Stack = new MyStack();
    }
    
    public boolean isEmpty()
    {
        return Stack.isEmpty();
    }
    
    public void add(Square s)
    {
        Stack.push(s);
    }
    
    public void remove()
    {
        Stack.pop();
    }
    
    public Square next()
    {
      return Stack.peek();  
    }
}
