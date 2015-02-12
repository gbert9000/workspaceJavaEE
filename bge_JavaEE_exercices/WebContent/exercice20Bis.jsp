<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 20 Bis</title>
</head>
<body>

 <center><h3>Contenu des éléments de la session</h3></center>
    <% //recuperation des éléments de la session
    String nom = (String)session.getAttribute("nom");
    String prenom = (String)session.getAttribute("prenom");
    String age = (String)session.getAttribute("age");
    
    if(nom != null)out.println("Votre nom est : " + nom + "<br />");
    if(prenom != null)out.println("Votre prénom est : " + prenom + "<br />");
    if(age != null)out.println("Votre age est : " + age + "<br />");
    
    if(nom == null && prenom == null && age == null)out.println("<br />Aucun élément(s) dans la session courante !!!<br />");
    
    %>        

</body>
</html>