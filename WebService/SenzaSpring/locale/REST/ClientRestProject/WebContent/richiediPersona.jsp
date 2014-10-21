<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session = request.getSession();
int tot = (Integer) session.getAttribute("totale");

String action = request.getParameter("a");
String a = null;
String url = null;

if(action.equals("del")){
	a = "cancellarne";
	url = "CancellaPersonaServlet";
	
}	
if(action.equals("show")){
	a = "vederne";
	url = "RecuperaPersonaServlet";
}
if(action.equals("update")){
	a = "aggiornarne";
	url = "AggiornaPersonaServlet";
}
	
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Richiedi persona</title>
</head>
<body>
<h1>Richiedi Persona</h1>
<p>In totale ci sono <% out.println(tot); %> persone</p>
<p>Scegli l'id di una persona per <% out.println(a); %> tutti i dati</p>
<form action="<% out.println(url); %>" method="post">
	Scegli un id
	<select name="id">
		<%
		for(int i = 1; i<= tot; i++ ){
			out.println("<option value="+i+">"+i+"</option>");
		}
		 %>
		<!--  <option value="1">1</option>-->
	</select>
	<br/>
	Invia: <input type="submit" value="invia"/>
</form>
</body>
</html>