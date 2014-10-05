package it.uniroma3.dia.asw.rmi.client;



import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.uniroma3.dia.asw.rmi.service.SqrtService;
import it.uniroma3.dia.asw.rmi.service.SqrtServiceException;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.RemoteLookupFailureException;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecurityManager sm = new MySecurityManager();
		System.setSecurityManager(sm);
		
		
		
		try{
			System.out.println("========CLIENT========");
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-client.xml");
			SqrtService sqrtService = (SqrtService)context.getBean("sqrtService");
			
			//String input = JOptionPane.showInputDialog("Inserisci un numero");
			//Double x = Double.parseDouble(input);
			System.out.println("Inserire un numero");
			Scanner in = new Scanner(System.in);
			Double x = in.nextDouble();
			
			double sqrtResult = sqrtService.getSqrt(x);
			System.out.println("Il risultato e': " + sqrtResult);
			
			//System.out.println("Provo con 4");
			//double sqrtResult1 = sqrtService.getSqrt((double)4);
			//System.out.println("Il risultato e': " + sqrtResult1);
			
			//System.out.println("Provo con 0");
			//double sqrtResult2 = sqrtService.getSqrt((double)0);
			//System.out.println("Il risultato e': " + sqrtResult2);
			
			//System.out.println("Provo con -25");
			//double sqrtResult3 = sqrtService.getSqrt((double)-25);
			//System.out.println("Il risultato e': " + sqrtResult3);
			
			//System.out.println("Provo con null");
			//double sqrtResult4 = sqrtService.getSqrt(null);
			//System.out.println("Il risultato e': " + sqrtResult4);
			
			
		}catch(SqrtServiceException e){
			System.out.println("Errore Funzionale");
			System.out.println("Causa Originaria: " + e.getInfo());
		}//fine catch
		catch(InputMismatchException e){
			System.out.println("Errato inserimento del numero");
			System.out.println("Causa Originaria: " + e.getCause());
		}//fine catch
		catch(NumberFormatException e){
			System.out.println("Errato inserimento del numero");
			System.out.println("Causa Originaria: " + e.getCause());
		}//fine catch
		catch(NullPointerException e){
			System.out.println("Chiusura della finestra senza inserire dati");
			System.out.println("Causa Originaria: " + e.getCause());
		}//fine catch
		catch(RemoteLookupFailureException e){
			System.out.println("Errore nel lookup");
			System.out.println("Causa Originaria: " + e.getCause());			
		}
		catch(BeanCreationException e){
			System.out.println("Errore nella creazione del Bean");		
			System.out.println("Causa Originaria: " + e.getCause());				
		}//fine catch
		catch(BeanDefinitionStoreException e){
			System.out.println("Errore nel caricamento del file di contesto");
			System.out.println("Causa Originaria: " + e.getCause());
		}//fine catch
		
		System.out.println("========FINE CLIENT========");

	}

}
