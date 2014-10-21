<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Restful Web Service</title>
</head>
<body>
<h1>Client Restful Web Service</h1>
<p>Client di un Restful Web Service dove e' possibile compiere operazioni su un elenco di persone.</p>
<h2>Azioni</h2>
<ul>
	<li><a href="TotaleServlet?a=show">Richiedi una persona</a></li>
	<li><a href="TotaleServlet?a=update">Aggiorna una persona</a></li>
	<li><a href="aggiungiPersonaFormView.jsp">Aggiungi una persona</a></li>
	<li><a href="TotaleServlet?a=del">Cancella una persona</a></li>
</ul>
</body>
</html>