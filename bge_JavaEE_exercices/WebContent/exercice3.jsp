<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 3</title>
</head>
<body>
	<%!
	        long factorielle(int n){
		      long resultat = 1;
	          int i = 1;
	
	          if(n == 0 || n == 1)resultat = 1;
	          else{  
	        	  for(i = 1; i <= n; i++){
	                 	  resultat *= i; 
	        	  }
	          }
	          return resultat;        
	        };
	        
	        long sommeNtermesSuiteArth(int n)
	        { long resultat = 0;
	          int i = 1;        
	          for(i = 1 ; i <= n ; i++) resultat += i ;
	          return resultat; 
	        }
	        
	        %>

	<h3>Résultat de la fonction factorielle</h3>
	3! =
	<%=factorielle(3)%>
	<br />
	4! =
	<%=factorielle(4)%>
	<br />
	10! =
	<%=factorielle(10)%>
	<br />
	
	<h3>Résultat de la somme des n premiers termes d'une suite arithmétique</h3>
	Pour n = 50, somme = <%=sommeNtermesSuiteArth(50)%>
	<br />
	Pour n = 1000, somme = <%=sommeNtermesSuiteArth(1000)%>
	<br />


</body>
</html>