package it.parisnews.test.wb.client;

import org.springframework.web.client.RestTemplate;

public class PersonaController {

	private RestTemplate restTemplate;
	private PersonaClient client;
	
	
	public PersonaController(RestTemplate restTemplate, PersonaClient client) {
		
		this.restTemplate = restTemplate;
		this.client = client;
		
	}
	
	
	/*
	 * Metodo usato per testare il webservice
	 */
	public void run(){
		System.out.println("Provo a fare il Get di una persona");
		Persona p = client.retrievePersona(4);
		p.stampaPersona();
		
		System.out.println("Modifico una persona e provo ad aggiornarla mediante PUT");
		p.setNome("Danilo");
		p.setCognome("Soddimo");
		p.setEta(28);
		
		client.updatePersona(p);
		
		System.out.println("Verifico che l'aggiornamento sia andato a buon fine");
		Persona pu = client.retrievePersona(4);
		pu.stampaPersona();
		
		System.out.println("Cancello persona");
		client.deletePersona(4);
		
		System.out.println("Post di una nuova persona");
		Persona p2 = new Persona();
		p2.setId(5);
		p2.setNome("Nome");
		p2.setCognome("Cognome");
		p2.setEta(28);
		
		Persona p2r = client.postPersona(p2);
		p2r.stampaPersona();
		
		System.out.println("verifico Post");
		Persona ver = client.retrievePersona(5);
		ver.stampaPersona();
	}/*fine metodo run*/
	
	
	
}
