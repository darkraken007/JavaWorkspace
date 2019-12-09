package main.sevenplus;

import main.sevenplus.Point;

public class TraingleAWByType
{
    private Point pointA;
    private Color color;

    public Color getColor()
    {
        return color;
    }
    public void setColor( Color color )
    {
        this.color = color;
    }
    public TraingleAWByType(){
        
    }
    public TraingleAWByType( Point pointA, Color color )
    {
        super();
        this.pointA = pointA;
        this.color = color;
    }



    public Point getPointA()
    {
        return pointA;
    }

    public void setPointA( Point pointA )
    {
        this.pointA = pointA;
    }
    
    public void draw(){
        
        System.out.println( pointA + "with color " + color);
    }
}
