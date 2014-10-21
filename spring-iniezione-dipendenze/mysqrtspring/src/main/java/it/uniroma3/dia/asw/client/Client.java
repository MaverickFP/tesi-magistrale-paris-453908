package it.uniroma3.dia.asw.client;

import it.uniroma3.dia.asw.service.SqrtService;
import it.uniroma3.dia.asw.service.SqrtServiceException;

public class Client {
	
	private SqrtService service;
	private double numeroInput;
	
	public Client(){
		
	}
	
	public Client(SqrtService service){
		this.service = service;
		this.numeroInput = (double) 9;
	}
	
	public Client(SqrtService service, double n){
		this.service = service;
		this.numeroInput = (double) n;
	}
	

	public void setService(SqrtService service) {
		this.service = service;
	}

	
	public void setNumeroInput(double numeroInput) {
		this.numeroInput = numeroInput;
	}
	

	public void run(){
		try{
			double ris = service.getSqrt(numeroInput);
			System.out.println("Il risultato e': " + ris);
		}catch(SqrtServiceException e){
			System.out.println("Errore Funzionale");
			System.out.println("Causa Originaria: " + e.getInfo());
		}
		
	}//fine metodo run

}
