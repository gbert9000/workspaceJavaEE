<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 2</title>
</head>
<body>

<%
        String message1 = "Bienvenue dans le monde de <b>Java/JavaEE</b>";
        message1 = message1 + " et de la programmation Internet Avancée. <br>";
        
        String message2 = "Nous allons faire le tour des concepts";
        message2 = message2 + " fondamentaux de ces technologies. <br />";
        %>
        <!-- mise en majuscule-->
        <%= message1.toUpperCase() %>
        <%= message2.toUpperCase() %>
        <hr />
        <!-- mise en minuscule-->
        <%= message1.toLowerCase() %>
        <%= message2.toLowerCase() %>
        <hr />
        <!-- Longueur des messages-->
        Le message, <b><%= message1 %> </b> contient  <%= message1.length()%>
        caractères.<br /><br /><br />
        
        Le message, <b><%= message2 %> </b> contient  <%= message2.length()%>
        caractères.<br />

</body>
</html>