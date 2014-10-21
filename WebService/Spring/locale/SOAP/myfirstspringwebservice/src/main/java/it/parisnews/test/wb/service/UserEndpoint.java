package it.parisnews.test.wb.service;

import it.parisnews.serviceschema.DelUserRequest;
import it.parisnews.serviceschema.DelUserResponse;
import it.parisnews.serviceschema.GetUserRequest;
import it.parisnews.serviceschema.GetUserResponse;
import it.parisnews.serviceschema.SetUserRequest;
import it.parisnews.serviceschema.SetUserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



/*
 * L'endpoint e' il cuore della realizzazione di un web service con Spring. Permette di accedere ai servizi di business dell'applicazione
 * e di gestire le richieste e risposte.
 * http://docs.spring.io/spring-ws/site/reference/html/server.html
 */
@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://www.parisnews.it/serviceSchema";
	
	private UserRepository userRepository;

	//inietto con l'annotazione nel costruttore il servizio di business
	@Autowired
	public UserEndpoint(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request){
		GetUserResponse response = new GetUserResponse();
		response.setUser(userRepository.findUser(request.getUserid()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setUserRequest")
	@ResponsePayload
	public SetUserResponse setUser(@RequestPayload SetUserRequest request){
		SetUserResponse response = new SetUserResponse();		
		response.setUser(userRepository.addUser(request.getUser()));
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "delUserRequest")
	@ResponsePayload
	public DelUserResponse delUser(@RequestPayload DelUserRequest request){
		DelUserResponse response = new DelUserResponse();
		response.setSuccess(userRepository.delUser(request.getUserid()));		
		return response;
	}
	
	
}
