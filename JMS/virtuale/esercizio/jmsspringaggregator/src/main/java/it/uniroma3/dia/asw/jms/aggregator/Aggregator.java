package it.uniroma3.dia.asw.jms.aggregator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregator {
	
	private Producer producer;
	
	private Map<String, String> mappa; 
	
	public Aggregator(){
		this.mappa = new HashMap<String, String>();
	}
	
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	
	public void addElemento(String id, String num){
		Boolean b = mappa.containsKey(id);
		
		
		if(mappa.containsKey(id)){
			
			String val = mappa.get(id);
			String ris = val + "," + num;
			
			//mappa.replace non è presente in open jdk (ovvero su java presente in vagrant)
			//ho risolto facendo una remove e un put
			
			//mappa.replace(id, ris);
			mappa.remove(id);
			mappa.put(id, ris);
			
			
			String output = id + "," + ris;
			
			this.invia(output);
		}/*fine if controllo esistenza chiave*/
		else{
			
			mappa.put(id, num);
		}/*fine else controllo esistenza chiave*/
			
			
			
	}/*fine addElemento*/
	
	
	
	public void invia(String s){
		producer.inviaMessaggio(s);
	}
	
	

}
