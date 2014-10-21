package it.uniroma3.dia.asw.jms.sender;





import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;




/*
 * Sender e' un producer di messaggi di tipo stringa. I messaggi vengono
 * inviati alla coda test.coda
 */
public class Sender {
	
	
JmsTemplate jmsTemplate;

	
	public Sender(){
		
	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	
	public void inviaMessaggio(final String msg){
		
		System.out.println("Invio: " + msg);
		
		jmsTemplate.send("test.coda",
				new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
	            return session.createTextMessage(msg);
	        }
		});
		System.out.println("Inviato!");
		
	}/*fine invia Messaggio*/

}
