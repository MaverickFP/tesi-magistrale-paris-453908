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
<title>Vedi Persona</title>
</head>
<body>
<h1>Persona</h1>
<p>Di seguito i dati della persona richiesta:</p>
<ul>
	<li><strong>ID: </strong> <% out.print(id); %> </li>
	<li><strong>Nome: </strong> <% out.print(nome); %> </li>
	<li><strong>Cognome: </strong> <% out.print(cognome); %> </li>
	<li><strong>Eta: </strong> <% out.print(eta); %> </li>
</ul>
<p>Torna alla <a href="index.jsp">Pagina Iniziale</a></p>
</body>
</html>