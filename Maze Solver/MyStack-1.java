import java.util.*;
/**
 * Write a description of class MyStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStack implements StackADT
{
    // instance variables - replace the example below with your own
    private Square[] stack;
    int size = 0;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack()
    {
        this.stack=new Square[7];
        this.size=size;
    }
    
    public MyStack(int initCap)
    {
        stack = new Square[initCap];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isEmpty()
    {
        // put your code here
        if(size==0)
        {
            return true;
        }
        return false;
    }
    
    public Square peek()
    {
        if(size==0)
       {
           throw new EmptyStackException();
       }
       
       Square top = stack[size-1];
       return top;
    }
    
    public Square pop()
    {
       if(size==0)
       {
           throw new EmptyStackException();
       }
       
       Square top = stack[size-1];
       size--;
       return top;
    }
    
    public void push(Square item)
    {
        if(size==stack.length)
        {
           doubleCapacity(); 
        }
        
        stack[size] = item;
        size++;
    }
    
    private void doubleCapacity()
    {
        int newCap = 2*stack.length;
        
        Square [] newStack = new Square [newCap];
        
        for(int i = 0; i<stack.length; i++)
        {
            newStack[i]=stack[i];
        }
        
        stack = newStack;
    }
    
    public String toString()
    {
        String result = "";
        for(int i =size-1; i>=0; i--)
        {
            if (stack!=null)
            {
                result+=stack[i].toString() + " \n";
            }
        }
        return result;
    }
    
    public int size()
    {
        return size;
    }
    
    public void clear()
    {
        Square [] newStack = new Square [stack.length];
        stack=newStack;
    }
}