package it.parisnews.test.wb.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import user.wsdl.DelUserRequest;
import user.wsdl.DelUserResponse;
import user.wsdl.GetUserRequest;
import user.wsdl.GetUserResponse;
import user.wsdl.SetUserRequest;
import user.wsdl.SetUserResponse;
import user.wsdl.User;

public class UserClient extends WebServiceGatewaySupport{
	
	public GetUserResponse getUserResponse(int userid){
		GetUserRequest request = new GetUserRequest();
		request.setUserid(userid);
		
		System.out.println();
		System.out.println("Inviata richiesta dati per l'utente con identificatore = " +userid);
		
		GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		
		return response;
		
	}
	
	
	
	public User setUserResponse(){
		SetUserRequest request = new SetUserRequest();
		User newUser = new User();
		newUser.setUserid(4);
		newUser.setName("Danilo");
		newUser.setSurname("Soddimo");
		newUser.setAge(28);
		newUser.setCity("Roma");
		
		request.setUser(newUser);
		System.out.println();
		System.out.println("Inviata richiesta aggiunta di un nuovo utente");
		SetUserResponse response = (SetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		
		User u = response.getUser();
		
		return u;
	}
	
	
	
	
	public int delUserResponse(int userid){
		DelUserRequest request = new DelUserRequest();
		request.setUserid(userid);
		System.out.println();
		System.out.println("Inviata richiesta di cancellazione per l'utente con identificatore = " + userid);
		
		DelUserResponse response = (DelUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		int ris = response.getSuccess();
		
		return ris;
	}
	
	
	public void printRisCancellazioneUser(int i){
		if(i==0)
			System.out.println("Cancellazione non riuscita");
		else
			System.out.println("Cancellazione riuscita");
	}
	
	
	public void printUtente(User utente){
		int id = utente.getUserid();
		String nome = utente.getName();
		String cognome = utente.getSurname();
		int eta = utente.getAge();
		String citta = utente.getCity();
	
		System.out.println("=== Dati Ricevuti ===");
		System.out.println("UserId: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Cognome: " + cognome);
		System.out.println("Eta: " + eta);
		System.out.println("Citta': " + citta);
		System.out.println("=== Fine Dati Ricevuti ===");
	}
	
	
	
	public void printResponse(GetUserResponse response){
		
		User utente = response.getUser();
	
			int id = utente.getUserid();
			String nome = utente.getName();
			String cognome = utente.getSurname();
			int eta = utente.getAge();
			String citta = utente.getCity();
		
			System.out.println("=== Dati Ricevuti ===");
			System.out.println("UserId: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("Cognome: " + cognome);
			System.out.println("Eta: " + eta);
			System.out.println("Citta': " + citta);
			System.out.println("=== Fine Dati Ricevuti ===");
			
			
	}
	

}
