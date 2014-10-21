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
 * Servlet implementation class CancellaPersonaServlet
 */
@WebServlet("/CancellaPersonaServlet")
public class CancellaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellaPersonaServlet() {
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
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		
		if( resp.getStatus() == 200){
			int output = (int) resp.getEntity(Integer.class);
			if(output == 1)
				response.sendRedirect("cancellaOkView.jsp");
			else{
				session = request.getSession();
				session.setAttribute("errore", "Errore nella cancellazione di un utente");
				response.sendRedirect("errorView.jsp");
			}	
			
		}/*fine if*/
		else{
			session = request.getSession();
			session.setAttribute("errore", "Errore nella risposta della cancellazione di un utente");
			response.sendRedirect("errorView.jsp");
		}
		
		
		
	}

}
