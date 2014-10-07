package it.uniroma3.dia.asw.jms.produttore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//

public class Gestore {
	
	private Map<String, Integer> mappaInput;
	private Map<String, String> mappaFinale;
	
	private Producer producer;
	
	public Gestore(){
		this.mappaInput  = new HashMap<String, Integer>();
		this.mappaFinale = new HashMap<String, String>();
	}
	
	
	public void setProducer(Producer producer) {
		this.producer = producer;
	}




	public void inizializzaDati(){
		for(int i = 1; i<= 10; i++){
			String id = "id"+i;
			mappaInput.put(id, i);
		}/*fine for*/
		
	}/*fine inizializza Dati*/
	
	
	public void inviaDati(){
		// Itero su tutti gli id, usando il metodo keySet
		for(String key: mappaInput.keySet()){
			String stringaDaInviare = key+","+mappaInput.get(key);
			producer.inviaMessaggio(stringaDaInviare);
			/*introduco del ritardo*/
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}/*fine invia dati*/
	
	
	
	
	public void addElemento(String id, String num){
		Integer intero = mappaInput.get(id);
		String ris = id + "," + intero + "," + num;
		mappaFinale.put(id, ris);
		System.out.println("La stringa finale e': " + ris);
			
			
	}/*fine addElemento*/
	
	
	

}
