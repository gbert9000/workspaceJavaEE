<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="paquet.DataBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Résultat</title>
</head>
<body>
	<h1>Voici le résultat d'un forward</h1>
	<% 
	DataBean db = (DataBean)request.getAttribute("db");
	out.write("Bonjour "+ db.getDonnees());
	%>
</body>
</html>