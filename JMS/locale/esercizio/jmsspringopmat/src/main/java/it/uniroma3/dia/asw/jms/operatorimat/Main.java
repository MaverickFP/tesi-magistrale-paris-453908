package it.uniroma3.dia.asw.jms.operatorimat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Avvio parte del sistema che svolge operazioni matematiche");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

	}

}
