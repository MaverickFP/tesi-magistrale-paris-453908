package it.uniroma3.dia.asw.client;

import it.uniroma3.dia.asw.service.SqrtService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		SqrtService service = (SqrtService) context.getBean("sqrtService");
		
		//primo modo - inietto il bean precedentemente ricavato usando il costruttore di default
		System.out.println("Primo Modo");
		Client client1 = new Client(service);
		client1.run();
		
		
		//secondo modo - inietto il service nel client direttamente nel file di configurazione
		System.out.println("Secondo Modo");
		Client client2 = (Client) context.getBean("client");
		client2.run();
		
		//terzo modo - inietto il service ed un valore numerico nel client usando il file di configurazione
		System.out.println("Terzo Modo");
		Client client3 = (Client) context.getBean("client2");
		client3.run();
		
		//quarto modo - inietto il service ed un valore numerico nel client usando il file di configurazione
		//ed in particolare l'elemento property. Tale meteodo necessita del costruttore vuoto e dei metodi
		// setter per il service ed numeroInput
		System.out.println("Quarto Modo");
		Client client4 = (Client) context.getBean("client3");
		client4.run();

	}

}
