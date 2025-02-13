public class FireCell
{
    public static final int DIRT = 0, GREEN = 1, BURNING = 2;
    private int status, row, col;

    public FireCell()
    {
        status = DIRT;
        if ( Math.random() <= 0.60 )
            status = GREEN;
    }
    
    public FireCell(int r, int c)
    {
        status = DIRT;
        if ( Math.random() <= 0.60 )
            status = GREEN;
            row = r;
            col=c;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int n)
    {
        status = n;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
}
