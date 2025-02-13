import java.util.*;
/**
 * Write a description of class Melody here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Melody
{
    // instance variables - replace the example below with your own
    private Queue<Note> notes = new LinkedList<Note>(); 

    /**
     * Constructor for objects of class Melody
     */
    public Melody()
    {
   
    }
    
    public Melody(Queue<Note> song)
    {
        //song = new LinkedList<Note>();
        //notes = song;
        int size = song.size();
        while(!song.isEmpty())
        {
            for(int x =0; x<size; x++)
            {
                notes.offer(song.poll());
            }
        }
    }
    
    public double getTotalDuration()
    {
        notes = new LinkedList<Note>();
        double time = 0.0;
        int size = notes.size();
        for(int i = 0; i<size; i++)
        {
            time += notes.poll().getDuration();
            if(notes.poll().isRepeat())
            {
              time+= notes.poll().getDuration() *2;
            }
        }
        return time;   
    }
    
    public String toString()
    {
        Queue <Note> info = new LinkedList<Note>();
        int size = info.size();
        String description ="";
        for(int i =0; i<size; i++)
        {
            description += info.poll().toString();
        }
        return description;
    }
    
    public void changeTempo(double tempo)
    {
       Queue <Note> change = new LinkedList<Note>();
       int size = change.size();
       for(int i =0; i<size; i++)
        {
           change.poll().setDuration(change.poll().getDuration() * tempo);
        }
    }
    
    public void reverse()
    {
        Stack<Note> reverse = new Stack<Note>();
        Queue<Note> rev = new LinkedList<Note>();
        int size = rev.size();
        for(int i =0; i<size; i++)
        {
            reverse.push(rev.poll());
        }
        int x = reverse.size();
        for(int y =0; y<x; y++)
        {
            rev.offer(reverse.pop());
        }
    }
    
    public void append(Melody other)
    {
        
    }
    
    public void play()
    {
        
    }
    
    public Queue<Note> getNotes()
    {
      return null;  
    }
}
  