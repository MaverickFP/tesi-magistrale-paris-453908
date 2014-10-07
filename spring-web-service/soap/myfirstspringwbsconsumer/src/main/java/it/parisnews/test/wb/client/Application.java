package it.parisnews.test.wb.client;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import user.wsdl.GetUserResponse;
import user.wsdl.SetUserResponse;
import user.wsdl.User;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = SpringApplication.run(UserConfiguration.class, args);
		
		
		UserClient userClient = ctx.getBean(UserClient.class);
		
		//recupero un utente attarverso l'id
		GetUserResponse response = userClient.getUserResponse(2);
		userClient.printResponse(response);
		
		//aggiungo un utente
		User u = userClient.setUserResponse();
		userClient.printUtente(u);
		
		//cancello un utente
		int ris = userClient.delUserResponse(4);
		userClient.printRisCancellazioneUser(ris);
		
	}

}
