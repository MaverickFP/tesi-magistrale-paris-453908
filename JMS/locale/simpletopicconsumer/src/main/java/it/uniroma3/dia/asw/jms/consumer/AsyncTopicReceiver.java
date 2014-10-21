package it.uniroma3.dia.asw.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsyncTopicReceiver implements MessageListener{
	
public void onMessage(Message message){
		
		
		try {
			String sr = ((TextMessage) message).getText();
			System.out.println("Messaggio Ricevuto Consumatore A: " + sr);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
