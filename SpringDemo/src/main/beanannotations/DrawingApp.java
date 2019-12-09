package main.beanannotations;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DrawingApp
{

    public static void main( String[] args )
    {
        AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("springAnnotations.xml");
        appContext.registerShutdownHook();  //register shutdown hook inturn asks spring to destroy beans once main method has been terminated.
        Triangle tri1 = (Triangle)appContext.getBean( "triangle" );
        tri1.draw();
        
    }

}
