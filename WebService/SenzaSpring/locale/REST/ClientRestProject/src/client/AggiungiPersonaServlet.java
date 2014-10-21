package client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class AggiungiPersonaServlet
 */
@WebServlet("/AggiungiPersonaServlet")
public class AggiungiPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupero info del form attraverso l'oggetto request
		int id = 0;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
				
		
		int etaint = Integer.parseInt(eta);
				
		Persona p = new Persona();
		p.setId(id);
		p.setNome(nome);
		p.setCognome(cognome);
		p.setEta(etaint);
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona");
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, p);
		if( resp.getStatus() == 200){
			
			response.sendRedirect("aggiungiPersonaOkView.jsp");
			
		}
		else{
			String output = "Errore nell'inserimento di una persona";
			session = request.getSession();
			session.setAttribute("errore", output);
			response.sendRedirect("errorView.jsp");
		}
		
		
		
	}

}
