package it.uniroma3.dia.asw.jms.aggregator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Avvio Aggregatore dati");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Aggregator aggregator = (Aggregator) context.getBean("aggregator");
		
	}

}
