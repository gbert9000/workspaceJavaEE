package paquet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseDonnees
 */
public class BaseDonnees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  /**
	  * URL de connection
	  */
	  private static String url = "jdbc:mysql://localhost:3306/utilisateurs";
	 
	  /**
	  * Nom du user
	  */
	  private static String user = "root";
	 
	  /**
	  * Mot de passe du user
	  */
	  private static String passwd = "";
	 
	  /**
	  * Objet Connection
	  */
	  private static Connection connect;
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseDonnees() {
        super();


    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		//Connection
	    if(connect == null){
	        try {
	          connect = DriverManager.getConnection(url, user, passwd);
	        
	          //Statement
	  	    	Statement requete = connect.createStatement();
	  	    	ResultSet resultat = requete.executeQuery("select *");
	  	    	while(resultat.next()){
	  	    		out.print(resultat.getString(0));
	  	    	}
	    	requete.close();
	    	connect.close();
	    	
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	    

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
