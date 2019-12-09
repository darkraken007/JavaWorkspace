package main.sevenplus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.inheritance.Triangle;

public class DrawingApp
{

    public static void main( String[] args )
    {
        //ApplicationContext appContext = new ClassPathXmlApplicationContext("springsevenplus.xml");
        ApplicationContext appContextAutoWire = new ClassPathXmlApplicationContext("springAutoWire.xml");
        //ApplicationContext appContextAutoWireByType = new ClassPathXmlApplicationContext("springAutoWireByType.xml");
       // Triangle tri1 = (Triangle)appContext.getBean( "triangle" );
       // tri1.draw();
        TraingleAWByType triAutoWire = (TraingleAWByType)appContextAutoWire.getBean( "triangle" ); //autowired properties. :D
        triAutoWire.draw();
        
        //TraingleAWByType triAutoWireByType = (TraingleAWByType)appContextAutoWireByType.getBean( "triangleAWByType" ); //autowired by Type properties. :D
        //triAutoWireByType.draw();
        
        //TraingleAWByType triAutoWireByConstructor = (TraingleAWByType)appContextAutoWireByType.getBean( "triangleAWByType1" );
        //triAutoWireByConstructor.draw();
    }

}
