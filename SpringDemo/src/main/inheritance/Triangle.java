package main.inheritance;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware
{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private String refBean;
    private String beanName;
    private ApplicationContext appContext;
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
    public void setBeanName( String name )
    {
        this.beanName = name;
        System.out.println( name );
        
    }
    @Override
    public void setApplicationContext( ApplicationContext context ) throws BeansException
    {
        this.appContext = context;
        
    }
}
