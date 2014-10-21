package it.uniroma3.dia.asw.jms.operatorimat;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsyncConsumerSqrt implements MessageListener{
	
	private Producer producer;
	
	public AsyncConsumerSqrt(){
		
	}
	
	
	public void setProducer(Producer producer) {
		this.producer = producer;
	}



	public void onMessage(Message message){
			try {
				String sr = ((TextMessage) message).getText();
				System.out.println("Messaggio Ricevuto Consumatore Sqrt: " + sr);
				String[] parts = sr.split(",");
				String part1 = parts[0]; //id#
				String part2 = parts[1]; //numero
				Double num = Double.valueOf(part2);
				Double risSqrt = Math.sqrt(num);
				String output = part1 + "," + risSqrt;
				producer.inviaMessaggio(output);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}/*fine metodo onMessage*/

}
