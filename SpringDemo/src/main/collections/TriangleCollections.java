package main.collections;

import java.util.List;

import main.inheritance.Point;

public class TriangleCollections
{
    private List<Point> points;

    public List<Point> getPoints()
    {
        return points;
    }

    public void setPoints( List<Point> points )
    {
        this.points = points;
    }

    public void draw()
    {
        System.out.println( points );
        
    }
    
}
