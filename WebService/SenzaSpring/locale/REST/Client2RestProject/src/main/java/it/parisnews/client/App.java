package it.parisnews.client;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;








import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



/**
 * Client per testare web service di tipo rest
 * uso libreria Jersey e json-simple
 * http://code.google.com/p/json-simple
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Test Client!" );
        Client client = Client.create();
        
        
        //richiedo numero totale di persone
		WebResource webResource = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/totale");
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (resp.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp.getStatus());
		}
				
		String output = resp.getEntity(String.class);		
		System.out.println("Numero totale delle persone: " + output);
		
		//metto nella variabile tot il totale delle persone
		int tot = Integer.parseInt(output);
		
		
		
		//richiedo una persona
		System.out.println("Richiedo una persona.");
		
		WebResource webResource2 = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/2");
		ClientResponse resp2 = webResource2.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (resp2.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp2.getStatus());
		}
		String s = resp2.getEntity(String.class);
		
		System.out.println("Stampo il json ricevuto in seguito alla richiesta.");
		System.out.println(s);
		
		//ricavo le info sulla persona giunta come stringa json usando json-simple
		Object obj = JSONValue.parse(s);
		JSONObject jsonObject = (JSONObject) obj;
		
		Long idpersona = (Long) jsonObject.get("id");
		String nomepersona = (String) jsonObject.get("nome");
		String cognomepersona = (String) jsonObject.get("cognome");
		Long etapersona = (Long) jsonObject.get("eta");
		
		System.out.println("===Stampo Info Ricevute===");
		System.out.println("Id: " + idpersona);
		System.out.println("Nome: " + nomepersona);
		System.out.println("Cognome: " + cognomepersona);
		System.out.println("Eta': " + etapersona);
		System.out.println("===Fine Info Ricevute===");
		
		//aggiungo un umano
		System.out.println("Aggiungo un umano");
		
		//creo un umano
		Umano p = new Umano();
		//l'id che inserisco qui e' ininfluente infatti viene settato dal server in base 
		//alle persone presenti nel repository
		p.setId(tot+1); 
		p.setNome("Dario");
		p.setCognome("Biasi");
		p.setEta(40);
		
		//creo una stringa json in cui va rispettato l'ordine usando json-simple
		Map obj1 = new LinkedHashMap();
		obj1.put("id", p.getId());
		obj1.put("nome",p.getNome());
		obj1.put("cognome", p.getCognome());
		obj1.put("eta",p.getEta());
		
		String soutput = JSONValue.toJSONString(obj1);
		System.out.println("Stringa in output");
		System.out.println(soutput);
		
		//invio il nuovo umano 
		Client c = Client.create();
		WebResource webResource3 = c.resource("http://localhost:8080/myfirstrestwebservice/api/persona");
		ClientResponse resp3 = webResource3.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, soutput);
	    
		
		//richiedo il nuovo umano appena aggiunto
		System.out.println("Richiedo l'umano appena aggiunto");
		int idumano = tot + 1 ;
		
		WebResource webResource4 = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/" + idumano);
		ClientResponse resp4 = webResource4.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (resp4.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp4.getStatus());
		}
		String result = resp4.getEntity(String.class);
		
		System.out.println("Stampo il json ricevuto in seguito all'ultima richiesta.");
		System.out.println(result);
		//ricavo le info sulla persona giunta come stringa json usando json-simple
		Object obj2 = JSONValue.parse(result);
		JSONObject jsonObject2 = (JSONObject) obj2;
				
		Long idpersona2 = (Long) jsonObject2.get("id");
		Integer intid = (int) (long) idpersona2;
		String nomepersona2 = (String) jsonObject2.get("nome");
		String cognomepersona2 = (String) jsonObject2.get("cognome");
		Long etapersona2 = (Long) jsonObject2.get("eta");
		Integer inteta = (int) (long) etapersona2;
		
    
		Umano u2 = new Umano();
		u2.setId(intid);
		u2.setNome(nomepersona2);
		u2.setCognome(cognomepersona2);
		u2.setEta(inteta);
		u2.stampaUmano();
		
		
    
    }/*fine main*/





}
