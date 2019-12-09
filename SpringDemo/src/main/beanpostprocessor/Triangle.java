package main.beanpostprocessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import main.sevenplus.Point;

public class Triangle implements InitializingBean,DisposableBean
{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private String refBean;
    public String getRefBean()
    {
        return refBean;
    }
    public void setRefBean( String refBean )
    {
        this.refBean = refBean;
    }
    public Triangle(){
        
    }
    public Triangle( Point pointA, Point pointB, Point pointC )
    {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }
    
    public Point getPointA()
    {
        return pointA;
    }
    public void setPointA( Point pointA )
    {
        this.pointA = pointA;
    }
    public Point getPointB()
    {
        return pointB;
    }
    public void setPointB( Point pointB )
    {
        this.pointB = pointB;
    }
    public Point getPointC()
    {
        return pointC;
    }
    public void setPointC( Point pointC )
    {
        this.pointC = pointC;
    }
    
    public void draw(){
        System.out.println( "PointA= " + pointA );
        System.out.println( "PointB= " + pointB );
        System.out.println( "PointC= " + pointC );
    }
    @Override
    public void destroy() throws Exception
    {
        System.out.println( "end lifecycle callback from disposableBean Interface" );
        
    }
    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println( "init lifecycle callback from InitializingBean Interface" );
        
    }
    
    public void initTriangle(){
        
        System.out.println( "init lifecycle callback from application context.xml" );
    }
    
    public void destroyTriangle(){
        
        System.out.println( "destroy lifecycle callback from application context.xml" );
    }
}
