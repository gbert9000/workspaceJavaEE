package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletModele extends HttpServlet {
    
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
    }//fin de doGet()
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        try{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletModele, creation de la base de données</title>");
        out.println("</head>");
        out.println("<body>");
        String user = this.getInitParameter("user");
        String pwd = this.getInitParameter("motDepasse");        
        if(creationBD(user,pwd) == true)
        out.println("<center><h1>Base de données créée</h1></center>");
        else out.println("<center><h1>Echec de création de la base de données !!!</h1></center>");        
        out.println("</body>");
        out.println("</html>");        
        out.close();
        }
        catch(Exception ex)
        {
        
        }        
        
    }
    
    /**description de la servlet*/
    public String getServletInfo() { return "ServletModele";}
    
    public boolean creationBD(String user,String pwd )
    {  boolean ok = false;
       //parametres de calcul
       Connection cx = null;
       Statement st = null;
       String bd = "create database if not exists bdToulousain";
       StringBuffer sb = new StringBuffer();
       String base =  "jdbc:mysql://localhost:3306/";
       try
       {
         Class.forName("com.mysql.jdbc.Driver");
         cx = DriverManager.getConnection(base,user,pwd);
         st = cx.createStatement();
         int compte  = st.executeUpdate(bd);
         if(compte != 0)
         {st.executeUpdate("use bdToulousain");         
          sb.append("create table if not exists tabClient(nom varchar(20) not null,");   
          sb.append("prenom varchar(20) ,email varchar(50))");
          st.executeUpdate(sb.toString());        
          sb.delete(0,sb.length());        
          sb.append("create table if not exists tabEmploye(nom varchar(20) not null,");   
          sb.append("prenom varchar(20), email varchar(50), poste varchar(50),statut varchar(50))");
          st.executeUpdate(sb.toString());        
          ok = true;
         }       
       
       }
       catch(SQLException esql)
       {  if(st != null)
          { try{ st.close();}catch(SQLException exc){}
          }
          if(cx != null)
          { try{ cx.close();}catch(SQLException exc){}
          }        
       }
       catch(Exception e)
       {
       }
       finally       
       { if(st != null)
          { try{ st.close();}catch(SQLException exc){}
          }
          if(cx != null)
          { try{ cx.close();}catch(SQLException exc){}
          }       
       }
       
       return ok;
    }//fin de la methode creationBD()
    
}//fin de la classe
