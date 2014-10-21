package it.parisnews.client;

import javax.ws.rs.core.MediaType;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Test Client!" );
        Client client = Client.create();
        //richiedo numero totale
		WebResource webResource = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/totale");
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (resp.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp.getStatus());
		}
		
		
		
		String output = resp.getEntity(String.class);		
		System.out.println("Numero totale delle persone: " + output);
		
		//richiedo una persona
		WebResource webResource2 = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/2");
		ClientResponse resp2 = webResource2.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (resp2.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp2.getStatus());
		}
		String s = resp2.getEntity(String.class);
		System.out.println(s);
		
		
		//aggiungo una persona
		System.out.println("Aggiungo una persona");
		Client c = Client.create();
		WebResource webResource3 = c.resource("http://localhost:8080/myfirstrestwebservice/api/persona");
		ClientResponse resp3 = webResource3.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, s);
	       
		
		
    
    
    }/*fine main*/





}
