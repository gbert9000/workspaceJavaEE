package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletBDToulousain extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String user = null;
    String pwd = null;
    Connection cx = null;
    String base = "jdbc:mysql://localhost:3306/bdToulousain";
    
    public void init(ServletConfig config)
    throws ServletException{       
        
        //mise place de la connexion
        try
        { super.init(config);
          user = config.getInitParameter("user");
          pwd = config.getInitParameter("motDepasse");         
          Class.forName("com.mysql.jdbc.Driver");
          cx = DriverManager.getConnection(base,user,pwd);
        }
        catch(SQLException e)
        { if(cx != null)
          { try{ cx.close();}catch(SQLException exc){}
          }
        }
        catch(Exception e){}        
        
    }//fin de init()
    
    public void destroy()
    {
        if(cx != null)
          { try{ cx.close();}
            catch(SQLException exc){}
          }    
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try
        {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          String action = request.getParameter("action");
          String categorie = request.getParameter("categorie");
        
          out.println("<html>");
          out.println("<head>");
          out.println("<title>ServletBDToulousain</title>");
          out.println("</head>");
          out.println("<body>");
          if(action == null)out.println("<h1>Aucune action sélectionnée</h1>");
          else if("voir".equals(action) && categorie != null && "client".equals(categorie))select(out,categorie);
          else if("voir".equals(action) && categorie != null && "employe".equals(categorie))select(out,categorie);
          else if("ajouter".equals(action))
          {    if(insert(request) == true) out.println("<h1>Insertion dans la base réussie</h1>");
               else out.println("<h1>Echec d'insertion dans la base</h1>");        
          }
          else
          { out.println("<a href=\"/exercice23\">Ajouter un client ou un employé >>&nbsp;</a><br />");
          }
          
        out.println("</body>");
        out.println("</html>");        
        out.close();
        }
        catch(Exception e)
        {
        
        }
        
        
    }//fin de doPost()
    
    
    protected void select(PrintWriter out,String categorie)
    {       
       //parametres de calcul       
       Statement st = null;    
       ResultSet rslt = null;       
       String reqClient = "select * from tabClient";
       String reqEmploye = "select * from tabEmploye";
       
        try
        { st = cx.createStatement();
          //recuperation des données de la base
          if("client".equals(categorie))
          { rslt = st.executeQuery(reqClient);
            while(rslt.next())
            {out.println("<br />Nom : " + rslt.getString("nom") );
             out.println("<br />Prenom : " + rslt.getString("prenom") );                    
             out.println("<br />Email : " + rslt.getString("email") );            
             out.println("<br /><center><br /><hr /></center>");          
            }              
          }
         
          if("employe".equals(categorie))
          { rslt = st.executeQuery(reqEmploye);
            while(rslt.next())
            {out.println("<br />Nom : " + rslt.getString("nom") );
             out.println("<br />Prenom : " + rslt.getString("prenom") );                    
             out.println("<br />Email : " + rslt.getString("email") );
             out.println("<br />Poste : " + rslt.getString("poste") );
             out.println("<br />Statut : " + rslt.getString("statut") );
             out.println("<br /><center><br /><hr /></center>");          
            }         
          }
         
         rslt.close();
         st.close();
         
       }
       catch(SQLException esql)
       {  
          if(rslt != null)
          { try{ rslt.close();}catch(SQLException exc){}
          } 
          if(st != null)
          { try{ st.close();}catch(SQLException exc){}
          }               
       }
       catch(Exception e)
       {
       }
       finally       
       { 
          if(rslt != null)
          { try{ rslt.close();}catch(SQLException exc){}
          } 
          if(st != null)
          { try{ st.close();}catch(SQLException exc){}
          }               
       }      
      
    }
    
    
    protected boolean insert(HttpServletRequest request)
    {   boolean ok = false;        
        int nbre;        
        String reqClient = "insert into tabClient values(?,?,?)";
        String reqEmploye = "insert into tabEmploye values(?,?,?,?,?)";
        PreparedStatement pstClient = null;
        PreparedStatement pstEmploye = null;
        
        try
        {  
        //recuperation des parametres de la requete
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");        
        String poste = request.getParameter("poste");
        String email = request.getParameter("email");
        String statut = request.getParameter("statut");
        String type = request.getParameter("type");
              
        //insertion des données dans la base de données        
        //connexion a la base et creation d'un etat
        try{
           pstClient = cx.prepareStatement(reqClient);
           pstEmploye = cx.prepareStatement(reqEmploye);          
           if(pstClient != null && "client".equals(type))
            {  //requete d'insertion  dans la base
               if(nom != null && nom.length() > 1 && email != null)
               { pstClient.setString(1,nom);
                 pstClient.setString(2,prenom);
                 pstClient.setString(3,email);
                 nbre = pstClient.executeUpdate();
                 if(nbre != 0)ok = true;
               }                              
            } 
            
            if(pstEmploye != null && "employe".equals(type))
            {  //requete d'insertion  dans la base
               if(nom != null && nom.length() > 1)
               { pstEmploye.setString(1,nom);
                 pstEmploye.setString(2,prenom);
                 pstEmploye.setString(3,email);
                 pstEmploye.setString(4,poste);
                 pstEmploye.setString(5,statut);
                 nbre = pstEmploye.executeUpdate();
                 if(nbre != 0)ok = true;
               }                              
            }             
           
            //fermeture des ressources
            if(pstClient != null){ pstClient.close(); pstClient = null;}
            if(pstEmploye != null){ pstEmploye.close(); pstEmploye = null;}
                       
           }
          catch(SQLException e)
          { //fermeture des ressources en cas de problemes SQL          
            if(pstClient != null)
            { try{ pstClient.close();}catch(SQLException exc){}              
            }
            if(pstEmploye != null)
            { try{ pstEmploye.close();}catch(SQLException exc){}              
            }            
            return false;          
          }   
        
        }
        catch(Exception e){return false;}
    
        
       return ok;
       
    }//fin de la methode insert()
    
    
    /**description of the servlet.*/
    public String getServletInfo() { return "ServletBDToulousain"; }
    
}//fin de la classe
