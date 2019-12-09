package main.sevenplus;

public class Point
{
    private int y;
    private int x;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return "("+x+","+y+")";
    }
}
