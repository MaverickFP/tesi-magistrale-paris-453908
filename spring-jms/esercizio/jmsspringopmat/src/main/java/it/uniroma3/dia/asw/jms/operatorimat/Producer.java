package it.uniroma3.dia.asw.jms.operatorimat;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer {

	JmsTemplate jmsTemplate;
	
	public Producer(){
		
	}
	
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	public void inviaMessaggio(final String msg){
		System.out.println("Invio: " + msg);
		jmsTemplate.send("es1.codaRisMat",
				new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
	            return session.createTextMessage(msg);
	        }
		});
		System.out.println("Inviato!");
	}/*fine invia Messaggio*/
	
	
}
