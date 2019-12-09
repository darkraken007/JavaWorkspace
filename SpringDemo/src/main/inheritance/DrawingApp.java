package main.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp
{

    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("springInheritance.xml");
        Triangle tri1 = (Triangle)appContext.getBean( "triangle1" );
        tri1.draw();
        TriangleCollections triColl1 = (TriangleCollections)appContext.getBean( "triangleCollections1" );
        triColl1.draw();

    }

}
