package it.parisnews.test.wb.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class PersonaClient {
	
	
	private RestTemplate restTemplate;
	private String url = "http://localhost:8080/persona";
	
	public PersonaClient(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	
	
	public Persona retrievePersona(int id){
		String urlCompleta = url + "/{"+id+"}";
		Persona p = null;
		try{
			p = restTemplate.getForObject(urlCompleta, Persona.class, id);
		}catch(RestClientException e){
			System.out.println("Errore nel recupero (GET) di una persona");
		}
		return p;
	}/*fine metodo retrieve Persona*/
	
	
	
	public void updatePersona(Persona p){
		int id = p.getId();
		String urlCompleta = url + "/" + id;
		try {
			restTemplate.put(new URI(urlCompleta), p);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/*fine metodo update Persona*/
	
	
	
	public void deletePersona(int id){
		String urlCompleta = url + "/"+id;
		try{
			restTemplate.delete(new URI(urlCompleta));
		}catch(URISyntaxException wontHappen){
			System.out.println("Errore nel metodo per cancellare una persona.");
		}
	}/*fine metodo delete Persona*/
	
	
	public Persona postPersona(Persona p){
		Persona pers = null;
		pers = restTemplate.postForObject(url, p, Persona.class);
		
		return pers;
	}/*fine metodo postPersona*/
	
	

}
