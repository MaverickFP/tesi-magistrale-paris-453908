package it.uniroma3.dia.asw.jms.sender;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		System.out.println("SENDER TOPIC STARTED");
		SenderTopic sender = (SenderTopic) context.getBean("sender");
		
		//invio diversi messaggi alla coda (10 + 1 vuoto)
		int numMsg = 10;
		for(int i = 1; i<= numMsg; i++ ){
			try {
				
				String msg = "Messaggio #" +i +" da SenderTopic";
				sender.inviaMessaggio(msg);
				/*introduco del ritardo*/
				Thread.sleep(4000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/*fine for*/
		
		/*invio un messaggio vuoto*/
		String msg = null;
		sender.inviaMessaggio(msg);
		System.out.println("SENDER TOPIC STOP");

	}

}
