<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 6</title>
</head>
<body>

	<p>
	Bienvenue dans le monde de Java/JavaEE et de la programmation Internet avancée.<br/>
	Nous allons faire le tour des concepts fondamentaux de ces technologies.
	</p>

<%
	out.println ("Comment allez-vous?");
	out.println("Aujourd’hui il fait beau.");
%>

<!-- 2. On se propose dans cette partie de traiter des opérations sur un rectangle . Soit un rectangle de
4 m de largeur et de 16 m de longueur.
a. Ecrire une fonction permettant de calculer la surface de ce rectangle , puis afficher le résultat
du calcul.
b. Ecrire une fonction permettant de calculer le périmètre de ce rectangle puis afficher le résultat
du calcul.
c. Ecrire une fonction permettant de calculer la longueur de la diagonale de ce rectangle puis
afficher le résultat du calcul. -->


<%!
		long surfaceRectangle(int l, int L)
		{ long resultat = 0;
		  resultat = l*L ;
		  return resultat; 
		}
%>
<%!
		long perimetreRectangle(int l, int L)
		{ long resultat = 0;
		  resultat = (l+L)*2 ;
		  return resultat; 
		}
%>
<%!
		double diagonaleRectangle(double l, double L)
		{ double resultat = 0;
		  resultat = Math.hypot(l, L);
		  return resultat; 
		}
%>

	Largeur = 4m et Longueur = 16m;
	<h3>Résultat du calcul de surface </h3>
	Surface = <%=surfaceRectangle(4,16)%>

	<h3>Résultat du calcul de périmètre </h3>
	Périmètre = <%=perimetreRectangle(4,16)%>

	<h3>Résultat du calcul de diagonale </h3>
	Diagonale = <%=diagonaleRectangle(4,16)%>
	
	
	<!-- 3. On se propose dans cette partie de traiter des opérations sur un cercle . Soit un cercle de 4.5 m
		de rayon.
		a. Calculer puis afficher la surface de ce cercle.
		b. Calculer puis afficher la circonférence de ce cercle.
		c. Afficher le message Ce cercle est assez grand si la circonférence est supérieure à 14 m. Sinon
		afficher le message Ce cercle n’est pas grand.
		d. Refaire les calculs avec un cercle de diamètre 4m.
		  -->
		<br/><br/>
			<h3>Résultat pour le cercle </h3><br/>
		
		    <%!
    double surfaceCercle(double rayon)
    {return Math.PI*rayon*rayon; }
    
    double circonferenceCercle(double rayon)
    {return 2*Math.PI*rayon;}     
    %>    
    Rayon du cercle = 4,5 m <br />    
    a)Surface du cercle = <%= surfaceCercle(4.5)%> m<sup>2</sup> <br />
    b)Circonférence du cercle = <%= circonferenceCercle(4.5)%> m <br />
    c)
    <%
    if( circonferenceCercle(4.5) > 14 )out.println("Cercle est assez grand"); 
    else out.println("Cercle n'est pas grand");
    %>
    <br /><br />
    
    Rayon du cercle = 4 m <br />    
    a)Surface du cercle = <%= surfaceCercle(4)%> m<sup>2</sup> <br />
    b)Circonférence du cercle = <%= circonferenceCercle(4)%> m <br />
    c)
    <%
    if( circonferenceCercle(4) > 14 )out.println("Cercle est assez grand"); 
    else out.println("Cercle n'est pas grand");
    %>
    <br /><br />
		

</body>
</html>