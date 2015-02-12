package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import utils.Etudiant;

public class ServletExercice10 extends HttpServlet {    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* @param request servlet request
     * @param response servlet response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       doPost(request, response);
    }
    
    /* @param request servlet request
     * @param response servlet response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Etudiant et1 = new Etudiant();
        et1.setNom("Dupond");
        et1.setPrenom("Marie");
        et1.setAge(25);
        et1.setAdresse("Toulouse");
        et1.setEmail("dmarie@ccc.fr"); 
        
        Etudiant et2 = new Etudiant();
        et2.setNom("Tar");
        et2.setPrenom("Clarisse");
        et2.setAge(20);
        et2.setAdresse("Nantes");
        et2.setEmail("tclaris@cfdu.com");
        
        Etudiant et3 = new Etudiant();
        et3.setNom("Toto");
        et3.setPrenom("Jerome");
        et3.setAge(22);
        et3.setAdresse("Blagnac");
        et3.setEmail("tjerome@desr.fr");
        
        Etudiant et4 = new Etudiant();
        et4.setNom("Néral");
        et4.setPrenom("Pierre");
        et4.setAge(23);
        et4.setAdresse("Paris");
        et4.setEmail("np@frey.net");
        
        ArrayList<Etudiant> liste = new ArrayList<Etudiant>();
        liste.add(et1);
        liste.add(et2);
        liste.add(et3);
        liste.add(et4);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletExercice10</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<center><h3>Liste des étudiants du centre de formation</h3></center>");
        for(int i = 0; i < liste.size(); ++i)
        {  out.println("Nom : " +  ((Etudiant)liste.get(i) ).getNom() + "<br />");
           out.println("Prénom : " +  ((Etudiant)liste.get(i) ).getPrenom() + "<br />");
           out.println("Age : " +  ((Etudiant)liste.get(i) ).getAge() + "<br />");
           out.println("Adresse : " +  ((Etudiant)liste.get(i) ).getAdresse() + "<br />");
           out.println("Email : " +  ((Etudiant)liste.get(i) ).getEmail() + "<br />");
           out.println("<br /><center>----------------------------------------------</center><br />");
        }
        
        et4.setPrenom("Patrick");
        et4.setEmail("npatrick@frey.net");   
        out.println("<center><h3>Liste des étudiants du centre de formation après modifications </h3></center>");
         for(int i = 0; i < liste.size(); ++i)
        {  out.println("Nom : " +  ((Etudiant)liste.get(i) ).getNom() + "<br />");
           out.println("Prénom : " +  ((Etudiant)liste.get(i) ).getPrenom() + "<br />");
           out.println("Age : " +  ((Etudiant)liste.get(i) ).getAge() + "<br />");
           out.println("Adresse : " +  ((Etudiant)liste.get(i) ).getAdresse() + "<br />");
           out.println("Email : " +  ((Etudiant)liste.get(i) ).getEmail() + "<br />");
           out.println("<br /><center>----------------------------------------------</center><br />");
        }        
        
        out.println("</body>");
        out.println("</html>");
         
        out.close();
    }
    
    /**description de la servlet.*/
    public String getServletInfo() {return "ServletExercice10";}
    
}//fin de la classe
