package servlets;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;



public class ServletExercice9 extends HttpServlet {
            
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
       
        ArrayList<Integer> nombre = new ArrayList<Integer>();
                
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        for(int i = 100; i <= 1567; ++i ) nombre.add(new Integer(i));
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletExercice9</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1> 1.)Contenu du tableau </h1>");
        for(int i = 0; i < nombre.size(); ++i )
        {
           int valeur = ((Integer)nombre.get(i)).intValue();
           out.println(valeur + " ");
        }
        out.println("<h1> 2.)Nombre d'éléments du tableau </h1>");
        out.println(nombre.size());
        
        out.println("<br /> <h1> 3.)Suppression des éléments du tableau </h1>");
        nombre.remove(200);
        nombre.remove(265);
        
        for(int i = 0; i < nombre.size(); ++i )
        {
           int valeur = ((Integer)nombre.get(i)).intValue();
           out.println(valeur + " ");
        }       
        
        out.println("<h1>Nouveau nombre d'éléments du tableau </h1>");
        out.println(nombre.size());
        out.println("<br /><br />");        
        
        out.println("</body>");
        out.println("</html>");
         
        out.close();
    }
    
    /** Courte description de la servlet. */
    public String getServletInfo() {
        return "ServletExercice9";
    }
   
}


