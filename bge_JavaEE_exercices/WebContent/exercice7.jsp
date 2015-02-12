<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 7</title>
</head>
<body>

    <center><h3>1. Produit Scalaire de deux vecteurs</h3></center>
    
    <%! double produitScalaire(double u[],double v[] )
    {int n = u.length,i = 0;
     double resultat = 0.0;

     for(i = 0; i < n ; ++i) resultat += u[i]*v[i];
     return resultat;
    }    
    %>    
    <%
    double u[] = new double[4];
    u[0] = 2.5; u[1] = 5; u[2] = 41.5; u[3] = 10; 
    double v[] = new double[4];
    v[0] = -5.2; v[1] = 2.3; v[2] = -4; v[3] = 0.0;
    double w[] = new double[4];
    w[0] = -0.014; w[1] = 10; w[2] = 0; w[3] = 15; 
    %> 
    u(
    <% for(int i = 0; i < u.length; ++i)
       {out.println(u[i]);
        if(i < u.length - 1)out.println(",");
        else out.println(")");
       }
    
    %>    
    <br />
     v(
    <% for(int i = 0; i < v.length; ++i)
       {out.println(v[i]);
        if(i < v.length - 1)out.println(",");
        else out.println(")");
       }
    
    %>
     <br />     
    u*v = <%= produitScalaire(u,v)%> <br /><br />    
     w(
    <% for(int i = 0; i < w.length; ++i)
       {out.println(w[i]);
        if(i < w.length - 1)out.println(",");
        else out.println(")");
       }
    
    %>
     <br />
     
    v*w = <%= produitScalaire(v,w)%> <br />    
    
    <center><h3>2. Somme de deux vecteurs</h3></center>
    <%!
    double[] sommeVecteur(double u[], double v[])
    {int n = u.length, i = 0;
     double w[] = new double[u.length];

     for(i = 0; i < u.length; ++i)w[i] = u[i] + v[i];
     return w;     
    }    
    %>
    
    <br />
    <%
    double s[] = sommeVecteur(u,v);    
    %>
    
    u + v = (
    <% for(int i = 0; i < s.length; ++i)
       {out.println(s[i]);
        if(i < s.length - 1)out.println(",");
        else out.println(")");
       }
    %>
    <br /><br />
    <%
    s = sommeVecteur(v,w);    
    %>
    
    v + w = (
    <% for(int i = 0; i < s.length; ++i)
       {out.println(s[i]);
        if(i < s.length - 1)out.println(",");
        else out.println(")");
       }
	%> 

</body>
</html>