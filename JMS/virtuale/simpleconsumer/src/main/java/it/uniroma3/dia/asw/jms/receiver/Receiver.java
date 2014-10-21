package it.uniroma3.dia.asw.jms.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;




/*
 * Ricevitore sincrono
 */
public class Receiver {
	
	JmsTemplate jmsTemplate;
	
	public Receiver(){
		
	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	public String riceviMessaggio(){
		try{
			Message msg = jmsTemplate.receive("test.coda");
			String sr = ((TextMessage) msg).getText();
			return sr;
		}catch(JMSException jmsException){
			throw JmsUtils.convertJmsAccessException(jmsException);
		}
		
	}/*fine ricevi Messaggio*/

}
