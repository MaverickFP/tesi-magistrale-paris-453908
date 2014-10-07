package it.parisnews.test.wb.client;

import org.springframework.web.client.RestTemplate;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		PersonaClient client = new PersonaClient(restTemplate);
		
		PersonaController controller = new PersonaController(restTemplate, client);
		controller.run();		
		
	}

}
