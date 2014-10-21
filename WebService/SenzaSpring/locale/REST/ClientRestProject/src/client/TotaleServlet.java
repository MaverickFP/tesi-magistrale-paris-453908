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
 * Servlet implementation class TotaleServlet
 */
@WebServlet("/TotaleServlet")
public class TotaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/myfirstrestwebservice/api/persona/totale");
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if( resp.getStatus() == 200){
			int output = (int) resp.getEntity(Integer.class);
			session = request.getSession();
			session.setAttribute("totale", output);
			
			String ris = request.getParameter("a");
			if(ris.equals("show")){				
				response.sendRedirect("richiediPersona.jsp?a=show");
			}	
			if(ris.equals("del")){
				response.sendRedirect("richiediPersona.jsp?a=del");
			}
			if(ris.equals("update")){
				response.sendRedirect("richiediPersona.jsp?a=update");
			}	
			
			//se arrivo qui nessun caso previsto quindi errore
			//String erroutput = "Errore nello smistamento della richiesta";
			//session.setAttribute("errore", erroutput);
			//response.sendRedirect("errorView.jsp");
			
			
		}/*fine if*/
		else{
			String output = "Errore nella richiesta del numero totale di persone";
			session = request.getSession();
			session.setAttribute("errore", output);
			response.sendRedirect("errorView.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
