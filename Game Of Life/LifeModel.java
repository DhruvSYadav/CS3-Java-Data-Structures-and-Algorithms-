import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.Timer;
import java.util.*;
public class LifeModel implements ActionListener
{

    /*
     *  This is the Model component.
     */

    private static int SIZE = 60;
    private LifeCell[][] grid;
    
    LifeView myView;
    Timer timer;

    /** Construct a new model using a particular file */
    public LifeModel(LifeView view, String fileName) throws IOException
    {       
        int r, c;
        grid = new LifeCell[SIZE][SIZE];
        for ( r = 0; r < SIZE; r++ )
            for ( c = 0; c < SIZE; c++ )
                grid[r][c] = new LifeCell();

        if ( fileName == null ) //use random population
        {                                           
            for ( r = 0; r < SIZE; r++ )
            {
                for ( c = 0; c < SIZE; c++ )
                {
                    if ( Math.random() > 0.85) //15% chance of a cell starting alive
                        grid[r][c].setAliveNow(true);
                }
            }
        }
        else
        {                 
            Scanner input = new Scanner(new File(fileName));
            int numInitialCells = input.nextInt();
            for (int count=0; count<numInitialCells; count++)
            {
                r = input.nextInt();
                c = input.nextInt();
                grid[r][c].setAliveNow(true);
            }
            input.close();
        }

        myView = view;
        myView.updateView(grid);

    }

    /** Constructor a randomized model */
    public LifeModel(LifeView view) throws IOException
    {
        this(view, null);
    }

    /** pause the simulation (the pause button in the GUI */
    public void pause()
    {
        timer.stop();
    }
    
    /** resume the simulation (the pause button in the GUI */
    public void resume()
    {
        timer.restart();
    }
    
    /** run the simulation (the pause button in the GUI */
    public void run()
    {
        timer = new Timer(50, this);
        timer.setCoalesce(true);
        timer.start();
    }
    
    /**reset button*/
    public void reset()
    {
        
    } 
     

    /** called each time timer fires */
    public void actionPerformed(ActionEvent e)
    {
        oneGeneration();
        myView.updateView(grid);
    }

    /** main logic method for updating the state of the grid / simulation */
    private void oneGeneration()
    {
        for(int r =0; r< SIZE; r++)
        {
            for(int c =0; c<SIZE; c++)
            {
                int counter = CheckNeighbor(r,c);
                //survival
                if(grid[r][c].isAliveNow())
                {
                    if((counter>=0 && counter<2) || (counter>3 && counter<9))
                    {
                        grid[r][c].setAliveNext(false);
                    }
                    if(counter>1 && counter < 4)
                    {
                        grid[r][c].setAliveNext(true);
                    }
                }
                
                //birth
                 
                //birth
                if(grid[r][c].isAliveNow()==false && counter==3)
                {
                   grid[r][c].setAliveNext(true);
                }
            }
        }
        
        for(int r =0; r<SIZE; r++)
        {
            for(int c =0; c<SIZE; c++)
            {
              grid[r][c].setAliveNow(grid[r][c].isAliveNext());
            }
        }
    }
    
    
     private int CheckNeighbor(int row, int col)
    {
        int neighbors =0; 
        for(int r = row-1; r< row+2; r++)
        {
            for(int c = col-1; c<= col+1; c++)
        {
            //not the acctual box
            if(r>grid.length-1 || c>=grid[0].length || r<0 || c<0)  
            {
                continue;
            }
            //not a border
            if(r==row && c==col)
            {
                continue;
            }
            //if it is occupied
            if(grid[r][c].isAliveNow())
            {
                neighbors++;
            }
        }
    }
    return neighbors;
    }
}






