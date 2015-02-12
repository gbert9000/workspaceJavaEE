package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletExercice15 extends HttpServlet {    
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
        try
        {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          //recuperation des données
          String item[] = request.getParameterValues("item");
          String commentaire = request.getParameter("commentaire");
          String email = request.getParameter("email");
          String conseilcs = request.getParameter("conseilcs");
          String conseilsi = request.getParameter("conseilsi");
          String as = request.getParameter("as");
          String da = request.getParameter("da");
          
        
          out.println("<html>");
          out.println("<head>");
          out.println("<title>ServletExercice15</title>");
          out.println("</head>");
          out.println("<body>");
          out.println("<center><h3></h3>Données reçues de la JSP de l'exercice 13</center>");
          
          int choix = 0;
          if(item != null)
          { out.println("<b><u>Items choisis :</u></b><br />");
            for(int i = 0; i < item.length; ++i)
            { 
                try{choix = Integer.parseInt(item[i]);}
                 catch(NumberFormatException ex){choix = -1;}
              
                switch(choix)
                { case 1: out.println("Conseil en systèmes informatiques <br />");break;
                  case 2: out.println("Conseil en calculs scientifiques <br />");break;
                  case 3: out.println("Développement d'applications <br />");break;
                  case 4: out.println("Autres services<br /> ");break;
                  default: out.println("<br /> Aucun item sélectionné <br />");break;
                }          
             }
          }          
         
          if(request.getParameter("ttt") != null)
          { out.println("<b><u>Choix items</u></b> <br />");
            if("1".equals(conseilsi)) out.println("Conseil en systèmes informatiques <br />");
            if("2".equals(conseilcs)) out.println("Conseil en calculs scientifiques <br />");
            if("3".equals(da)) out.println("Développement d'applications <br />");
            if("4".equals(as)) out.println("Autres services <br />");          
          }
          
          if(email != null)out.println("<br /><b>Votre email : </b>" + email);
          if(commentaire != null)out.println("<br /><b>Votre commentaire :</b><br />  " + commentaire+ "<br/>");
                   
          
          out.println("</body>");
          out.println("</html>");        
          out.close();
        }catch(Exception ex)
        {
        }
        
    }   
    
    /** description de la servlet. */
    public String getServletInfo() { return "ServletExercice15"; }
   
    
}//fin de la classe
