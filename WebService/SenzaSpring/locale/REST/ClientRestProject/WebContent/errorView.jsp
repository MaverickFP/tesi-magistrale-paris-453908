<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session = request.getSession();
String err = (String) session.getAttribute("errore");

 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Errore</title>
</head>
<body>
<h1>ERRORE</h1>
<p>Si e' verificato un errore.</p>
<p>Dettaglio errore <strong><% out.print(err); %></strong> </p>
<p><a href="index.jsp">Torna all'inizio</a></p>

</body>
</html>