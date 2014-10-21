package it.uniroma3.dia.asw.rmi.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("java.rmi.server.hostname", "192.168.50.102");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-server.xml");
		System.out.println("Attendo richieste dai client ....");
	
		
		
		
		

	}

}
