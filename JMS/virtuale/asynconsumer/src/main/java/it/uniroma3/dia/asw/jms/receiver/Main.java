package it.uniroma3.dia.asw.jms.receiver;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BasicConfigurator.configure();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		

	}

}
