package it.parisnews.test.wb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class PersonaRepository {
	private static final List<Persona> persone = new ArrayList<Persona>();
	
	@PostConstruct
	public void initData(){
		
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNome("Francesco");
		p1.setCognome("Paris");
		p1.setEta(27);
		
		persone.add(p1);
		
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setNome("Roberto");
		p2.setCognome("Stellone");
		p2.setEta(40);
		
		persone.add(p2);
		
		Persona p3 = new Persona();
		p3.setId(3);
		p3.setNome("Luca");
		p3.setCognome("Toni");
		p3.setEta(32);
		
		persone.add(p3);
		
		Persona p4 = new Persona();
		p4.setId(4);
		p4.setNome("Damiano");
		p4.setCognome("Cunego");
		p4.setEta(32);
		
		persone.add(p4);
		
		
	}/*fine metodo initData*/

	
	/*
	 * Metodo che restituisce una persona 
	 * a partire da un id specificato
	 */
	public Persona getPersona(int id){
		Assert.notNull(id);
		Persona result = null;
		
		for(Persona p : persone){
			if(id == p.getId()){
				result = p;
			}
		}
		
		return result;
	}/*fine metodo getPersona*/
	
	
	
	
	public void cancellaPersona(int id){
		Assert.notNull(id);
		
		for(Iterator<Persona> iterator = persone.iterator(); iterator.hasNext();){
			Persona p = iterator.next();
			if(id == p.getId()){
				iterator.remove();
			}/*fine if*/
		}/*fine for*/
		
	}/*fine metodo cancella Persona*/


	
	public void aggiornaPersona(Persona pn){
		Assert.notNull(pn);
		
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
		Assert.notNull(pn);
		Persona p = new Persona();
		p.setId(pn.getId());
		p.setNome(pn.getNome());
		p.setCognome(pn.getCognome());
		p.setEta(pn.getEta());
		persone.add(p);
	}/*fine metodo aggiungi persona*/
	
	
	
}
