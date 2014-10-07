package it.uniroma3.dia.asw.jms.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsyncReceiver implements MessageListener{
	
	public void onMessage(Message message){
		
		
		try {
			String sr = ((TextMessage) message).getText();
			System.out.println("Messaggio Ricevuto: " + sr);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
