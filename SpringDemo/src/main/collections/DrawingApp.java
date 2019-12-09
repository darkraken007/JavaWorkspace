package main.collections;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp
{

    public static void main( String[] args )
    {
        //currently used way - eager loading.
        ApplicationContext apContext = new ClassPathXmlApplicationContext("springCollection.xml");
        TriangleCollections tr2 = (TriangleCollections)apContext.getBean( "triangleCollection" );
        
        tr2.draw();
       

    }

}
