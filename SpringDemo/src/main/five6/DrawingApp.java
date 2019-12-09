package main.five6;

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
        ApplicationContext apContext = new ClassPathXmlApplicationContext("springfive6.xml");
        Triangle tr2 = (Triangle)apContext.getBean( "triangle" );
        
        //deprecated- uses lazy loading
        BeanFactory beanFactory = new XmlBeanFactory( new FileSystemResource( "src/springfive6.xml" ) );
        Triangle tri1 = (Triangle)beanFactory.getBean( "triangleSingleConstructorInt" );
        tri1.draw();
        tr2.draw();

    }

}
