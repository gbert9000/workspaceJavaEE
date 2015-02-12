<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 21</title>
</head>
<body>

    <center><h3>Compteur du nombre de visite d'une page Web  </h3></center>
    <%   
    if(session.getAttribute("visiteur") != null)
      {out.println("<br /><b>Nombre de visiteurs de la page :</b> &nbsp;" + ((Integer)session.getAttribute("visiteur")).intValue());
        
        out.println("<br /> ");
      }
    else
     {   //Lecture et ecriture du nombre de visiteurs
         String nomFichier = "C:\\TEMP\\statistiques_exo21.txt";
         ObjectInputStream ois = null;
         ObjectOutputStream oos = null;
         File fichier = null;
         int nombre = 0;
         
	 try{
            fichier = new File(nomFichier);
	    if(fichier.exists())
              { //ouverture du fichier en lecture
                ois = new ObjectInputStream(new FileInputStream(nomFichier));
                nombre = ((Integer)ois.readObject()).intValue();
                nombre++;
                session.setAttribute("visiteur", new Integer(nombre));
                ois.close();                
                //ouverture du fichier en écriture
                oos = new ObjectOutputStream(new FileOutputStream(nomFichier));
                oos.writeObject( new Integer(nombre) );
                oos.close();
                out.println("<br /><b>Nombre de visiteurs de la page :</b> &nbsp;" + nombre);
                 out.println("<br /> ");
                
              }else
              {//ouverture du fichier en écriture
                oos = new ObjectOutputStream(new FileOutputStream(nomFichier));
                oos.writeObject( new Integer(nombre + 1) );
                oos.close();
                session.setAttribute("visiteur", new Integer(nombre + 1));
                out.println("<br /><b>Nombre de visiteurs de la page :</b> &nbsp;" + nombre + 1);
                
                out.println("<br /> ");
              }
	    }	  
          catch(Exception ex){}
          finally
          {
              try{ if(ois != null) ois.close(); }catch(Exception ex){}
              try{ if(oos != null) ois.close(); }catch(Exception ex){}
          }
          
     }    
    
    %>    

</body>
</html>