<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi Persona</title>
</head>
<body>
<h1>Aggiungi Persona</h1>
<p>Completa il form sottostante per aggiungere una nuova persona.</p>
<form action="AggiungiPersonaServlet" method="post">
	Nome: <input type="text" name="nome" /><br/>
	Cognome: <input type="text" name="cognome" /><br/>
	Eta':<input type="text" name="eta" /><br/>
	<input type="submit" value="invia"/>
</form>
</body>
</html>