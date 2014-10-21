package it.uniroma3.dia.asw.jms.produttore;



import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BasicConfigurator.configure();
		System.out.println("Avvio Produttore Iniziale dati");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Producer producer = (Producer) context.getBean("producer");
		//Gestore gestore = new Gestore(producer);
		Gestore gestore = (Gestore) context.getBean("gestore");
		
		gestore.inizializzaDati();
		gestore.inviaDati();
		System.out.println("Fino invio Iniziale dei dati");
		
		
		
		
	

	}

}
