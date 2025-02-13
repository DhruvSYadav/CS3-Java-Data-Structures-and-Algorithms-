public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */
    public void recursiveFire(FireCell cell)
    {
        if (cell.getRow() < 0 || cell.getRow() >= cell.getRow() || cell.getCol() < 0 || cell.getCol() >= cell.getCol() || myGrid[cell.getRow()][cell.getCol()].getStatus() != 1) {
            return;
        }
        myGrid[SIZE][SIZE].setStatus(2);
        recursiveFire(myGrid[cell.getRow()][cell.getCol() - 1]);
        recursiveFire(myGrid[cell.getRow()][cell.getCol() + 1]);
        recursiveFire(myGrid[cell.getRow() + 1][cell.getCol()]);
        recursiveFire(myGrid[cell.getRow() - 1][cell.getCol()]);
    }

    public void solve()
    {
        recursiveFire(myGrid[0, 0]);
          for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(myGrid[i][j]);
            }
            System.out.println();
        }
        myView.updateView(myGrid);
    }
    }
    


