package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletExercice20 extends HttpServlet {
    
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
        //recuperation des données
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String age = request.getParameter("age");
        //variables de calcul
        HttpSession ses = null;
        
        if(nom != null && nom.length() >= 2)
        { nom = nom.trim();
          ses = request.getSession();
          if(ses != null)
          { ses.setMaxInactiveInterval(30*60);
            if(nom != null) ses.setAttribute("nom",nom);
            if(prenom != null) ses.setAttribute("prenom",prenom);
            if(age != null) ses.setAttribute("age",age);
          }        
        }               
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletExercice20</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h3>Voici les données récupérées </h3></center>");
        if(nom != null) out.println("Nom  : " + nom + "<br />");
        if(prenom != null) out.println("Prénom  : " + prenom + "<br />");
        if(age != null) out.println("Age  : " + age + "<br />");
        
        String url = response.encodeURL("exercice20Bis.jsp");
        out.println("<br /><br /><a href=\"" + url + "\"> Voir les données contenues dans la session </a><br /><br />");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    /** description de la servlet. */
    public String getServletInfo() { return "ServletExercice20";}
   
}
