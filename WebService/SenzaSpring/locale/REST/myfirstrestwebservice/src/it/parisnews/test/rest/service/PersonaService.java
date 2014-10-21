package it.parisnews.test.rest.service;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/persona")
public class PersonaService{
	
	private PersonaRepository repo = null;
	
	public PersonaService(){
		repo = PersonaRepository.getInstance();
	}
	
	
	
	
	/*
	 * Restituisce una persona
	 */	
	@Path("/{c}")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getPersona(@PathParam("c") int i){
		Persona p = repo.getPersona(i);
		return p;
	}
	
	
	/*
	 * Restituisce il numero totale delle persone
	 */
	@Path("/totale")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumTotalePersone(){
		int ris = repo.getTotalePersone();		
		return ris;
	}
	
	
	/*
	 * Cancella una persona
	 */
	@Path("/{c}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int delPersona(@PathParam("c") int i){
		repo.cancellaPersona(i);
		return 1;
	}
	
	
	/*
	 * Aggiunge una persona
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Persona addPersona(Persona p){
		repo.aggiungiPersona(p);
		return p;
	}
	
	
	
	/*
	 * Aggiorna una persona
	 */
	@Path("/{c}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Persona aggiornaPersona(@PathParam("c") int i, Persona p){
		repo.aggiornaPersona(p);
		return p;
	}
	
	
	

}
