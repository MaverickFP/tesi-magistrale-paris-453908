package it.parisnews.test.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonaRepository {
	
	private static final List<Persona> persone = new ArrayList<Persona>();
	
	private static PersonaRepository instance = null;
	
	
	
	public PersonaRepository(){
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNome("Francesco");
		p1.setCognome("Paris");
		p1.setEta(28);
		
		persone.add(p1);
		
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setNome("Daniel");
		p2.setCognome("Ciofani");
		p2.setEta(30);
		
		persone.add(p2);
		
		
		Persona p3 = new Persona();
		p3.setId(3);
		p3.setNome("Damiano");
		p3.setCognome("Cunego");
		p3.setEta(35);
		
		persone.add(p3);
	}
	
	
	
	public static PersonaRepository getInstance() {
	      if(instance == null) {
	         instance = new PersonaRepository();
	      }
	      return instance;
	}
	
	
	/*
	 * Restituisce la lunghezza dell'elenco di persone
	 */
	public int getTotalePersone(){
		int ris = persone.size();
		return ris;
	}
	
	
	
	
	
	/*
	 * Metodo che restituisce una persona 
	 * a partire da un id specificato
	 */
	public Persona getPersona(int id){		
		Persona result = null;
		
		for(Persona p : persone){
			if(id == p.getId()){
				result = p;
			}
		}
		
		return result;
	}/*fine metodo getPersona*/
	
	
	
	public void cancellaPersona(int id){
		
		for(Iterator<Persona> iterator = persone.iterator(); iterator.hasNext();){
			Persona p = iterator.next();
			if(id == p.getId()){
				iterator.remove();
			}/*fine if*/
		}/*fine for*/
		
	}/*fine metodo cancella Persona*/
	
	
	
	public void aggiornaPersona(Persona pn){
		
		int id = pn.getId();
		
		for(Persona p : persone){
			if(id == p.getId()){
				p.setNome(pn.getNome());
				p.setCognome(pn.getCognome());
				p.setEta(pn.getEta());
			}
		}/*fine for*/
		
	}/*fine metodo aggiorna persona*/
	
	
	public void aggiungiPersona(Persona pn){
		
		int tot = persone.size();
		int id = tot+1;		
		
		Persona p = new Persona();
		p.setId(id);
		p.setNome(pn.getNome());
		p.setCognome(pn.getCognome());
		p.setEta(pn.getEta());
		persone.add(p);
	}/*fine metodo aggiungi persona*/
	

}
