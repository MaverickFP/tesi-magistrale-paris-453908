package it.uniroma3.dia.asw.jms.produttore;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsyncConsumer implements MessageListener{
	
	private Gestore gestore;
	
	public AsyncConsumer(){
		
	}
	
	

	public void setGestore(Gestore gestore) {
		this.gestore = gestore;
	}




	public void onMessage(Message message){
		try {
			String sr = ((TextMessage) message).getText();
			System.out.println("Messaggio Ricevuto dalla coda finale: " + sr);
			String[] parts = sr.split(",");
			String part1 = parts[0]; //id#
			String part2 = parts[1]; //numero
			String part3 = parts[2]; //numero
			String conc = part2 + "," + part3;
			
			gestore.addElemento(part1, conc);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}/*fine metodo onMessage*/

}
