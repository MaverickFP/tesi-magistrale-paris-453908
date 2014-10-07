package it.uniroma3.dia.asw.jms.aggregator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class AsyncConsumer implements MessageListener{
	
	private Aggregator aggregator;
	
	public AsyncConsumer(){
		
	}

	
	
	
	public void setAggregator(Aggregator aggregator) {
		this.aggregator = aggregator;
		
	}




	public void onMessage(Message message){
		try {
			String sr = ((TextMessage) message).getText();
			System.out.println("Messaggio Ricevuto: " + sr);
			String[] parts = sr.split(",");
			String part1 = parts[0]; //id#
			String part2 = parts[1]; //numero
			
			aggregator.addElemento(part1, part2);
			
			
			
			//String output = null;
			//producer.inviaMessaggio(output);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/*fine metodo onMessage*/

}
