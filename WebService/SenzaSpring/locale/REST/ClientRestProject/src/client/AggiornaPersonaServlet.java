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
 * Servlet implementation class AggiornaPersonaServlet
 */
@WebServlet("/AggiornaPersonaServlet")
public class AggiornaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiornaPersonaServlet() {
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
		String id = request.getParameter("id");
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/"+id);
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if( resp.getStatus() == 200){
			Persona output = resp.getEntity(Persona.class);
			
			session = request.getSession();
			session.setAttribute("id", output.getId());
			session.setAttribute("nome", output.getNome());
			session.setAttribute("cognome", output.getCognome());
			session.setAttribute("eta", output.getEta());
			
			response.sendRedirect("updatePersonaView.jsp");
			
		}/*fine if*/
		else{
			String output = "Errore nel recupero sulle info di una persona per aggiornarla";
			session = request.getSession();
			session.setAttribute("errore", output);
			response.sendRedirect("errorView.jsp");
		}
	}

}
