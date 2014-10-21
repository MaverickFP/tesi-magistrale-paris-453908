package it.parisnews.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SqrtBean service = (SqrtBean) context.getBean("service");
        double ris = service.getSqrt(100);
        System.out.println("Ris " + ris);
    }
}
