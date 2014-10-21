<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session = request.getSession();
int id = (Integer) session.getAttribute("id");
String nome = (String) session.getAttribute("nome");
String cognome = (String) session.getAttribute("cognome");
int eta = (Integer) session.getAttribute("eta");

 %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiorna Persona</title>
</head>
<body>
<h1>Aggiorna Persona</h1>
<p>Modifica il form per aggiornare una persona.</p>
<form action="DoAggiornaPersonaServlet" method="post">
	<input type="hidden" name="id" value="<%out.print(id);%>"/>
	Nome: <input type="text" name="nome" value="<%out.print(nome);%>"/><br/>
	Cognome: <input type="text" name="cognome" value="<%out.print(cognome);%>"/><br/>
	Eta':<input type="text" name="eta" value="<%out.print(eta);%>"/><br/>
	<input type="submit" value="invia"/>
</form>
</body>
</html>