package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.StringBuffer;

public class ServletExercice12Bis extends HttpServlet {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**@param request servlet request
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
        {response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        //recuperation des parametres d'initialisation
        String identifiant= this.getInitParameter("login");
        String motDepasse = this.getInitParameter("motDepasse");
        //recuperation des parametres de la requete
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");        
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletExercice12Bis</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h3>Formulaire de saisies </h3></center>");
        sb.append("<form action=\"ServletExercice12Bis\" method=\"post\" name=\"formAuthentification\">");
        sb.append("    <table style=\"border: 1px solid red;\">");
        sb.append("        <tr><td>Login : </td>");
        sb.append("            <td> <input type=\"text\" name=\"login\" value=\"\" maxlength=\"15\" size=\"25\" /> </td>");
        sb.append("        </tr>");
        sb.append("        <tr><td>Mot de passe : </td><td> <input type=\"password\" name=\"pwd\" value=\"\" maxlength=\"15\" size=\"25\" /> </td>");
        sb.append("        </tr>");        
        sb.append("        <tr><td></td>");
        sb.append("            <td> <input type=\"hidden\" name=\"xx\" value=\"1\" /> </td>");
        sb.append("        </tr>");        
        sb.append("        <tr><td> &nbsp;</td>");
        sb.append("            <td><input type=\"reset\" name=\"annuler\" value=\"Annuler\" />&nbsp; &nbsp;");
        sb.append("                <input type=\"submit\" name=\"valider\" value=\"Valider\" /> </td>");
        sb.append("        </tr>");                 
        sb.append("   </table>");
        sb.append("</form><br />" );        
        out.println(sb.toString());
        
        //verification de la presence des données
        if(login != null && login.length() > 3 &&  pwd != null && pwd.length() > 3 )
        {   
            StringBuffer sb1 = new StringBuffer();
            sb1.append("<hr />");
            sb1.append("<center><h3>Authentification du client</h3></center>");
            out.println(sb1.toString());
            if(identifiant.equals(login) && motDepasse.equals(pwd))
            {out.println("<br /> Identification réussie !!! <br />");
            }
            else
            {out.println("<br />Echec de connexion <br />");            
            }
            
        }else
        { if(request.getParameter("xx") != null)
          {  out.println("<hr /><center><h3>Authentification du client</h3></center>");
             out.println("<br />Echec de connexion <br />");
          }
        }
        
        out.println("</body>");
        out.println("</html>");       
        out.close();        
        }
        catch(Exception ex){}        
        
    }
    
    /** description de la servlet.*/
    public String getServletInfo() {  return "ServletExercice12Bis"; }
  
}
