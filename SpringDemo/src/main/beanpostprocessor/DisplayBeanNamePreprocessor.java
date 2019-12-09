package main.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanNamePreprocessor implements BeanPostProcessor
{
    
    public DisplayBeanNamePreprocessor()
    {
    }
    @Override
    public Object postProcessAfterInitialization( Object bean, String beanName )
        throws BeansException
    {
        System.out.println( "After init postprocessor - " +beanName );
        return bean;
    }
    
    @Override
    public Object postProcessBeforeInitialization( Object bean, String beanName )
        throws BeansException
    {
        // TODO Auto-generated method stub
        System.out.println( " Before init postprocessor - " +beanName );
        return bean;
    }

}
