<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil JSP</title>
</head>
<body>
	<h1> Bienvenue dans la JSP !</h1>
	<% 
		for (int i=0;i<10;i++)
			out.println("Texte = "+i);
	%>
</body>
</html>