<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html 
	xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<!-- exemple de syntaxte if, boucle,... -->
<jstl:forEach var="compteur" begin="10" end="15">
	<jstl:if test="${comteur % 2 ==0}">
		<p>${compteur}</p>
	</jstl:if>
</jstl:forEach>

<jstl:forEach var="couleur" items="rouge vert bleu blanc orange">
	<p>${couleur}</p>
</jstl:forEach>

<jstl:forEach var="couleur" items="${couleurs.couleurs}">
	<p>${couleur}</p>
</jstl:forEach>


</body>
</html>