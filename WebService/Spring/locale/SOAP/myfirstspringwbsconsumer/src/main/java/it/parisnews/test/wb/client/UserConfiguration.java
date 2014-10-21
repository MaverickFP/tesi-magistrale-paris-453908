package it.parisnews.test.wb.client;



import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class UserConfiguration {
	
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("user.wsdl");
		return marshaller;
	}
	
	
	
	@Bean
	public UserClient userClient(Jaxb2Marshaller marshaller) {
		UserClient client = new UserClient();
		//client.setDefaultUri("http://localhost:8080/ws/users");
		//client.setDefaultUri("http://192.168.50.102:8080/ws");
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
