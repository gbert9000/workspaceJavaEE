package servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExercice12
 */
@WebServlet("/servlets/ServletExercice12")
public class ServletExercice12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExercice12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{ 
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        //recuperation des données
	        String civilite = request.getParameter("civilite");
	        String nom = request.getParameter("nom");
	        if(nom != null && nom.length() > 2)nom = nom.trim();
	        else nom = null;
	        String prenom = request.getParameter("prenom");
	        if(prenom != null && prenom.length() > 2)prenom = prenom.trim();
	        String ag = request.getParameter("age");
	        String adresse = request.getParameter("adresse");
	        String email = request.getParameter("email");
	        String niveau = request.getParameter("niveau");
	        //variables de calcul
	        int age = 0;
	        String repertoire = "C:\\TEMP\\";
	        String nomFichier = null;
	        if(nom != null && !" ".equals(nom))nomFichier = nom;
	        if(prenom != null && !" ".equals(prenom))nomFichier += prenom;        
	        
	        try
	        {age = Integer.parseInt(ag);
	        }catch(NumberFormatException e){age = 0; }
	        
	        //creation du fichier des données
	        if(nomFichier != null && nom != null && !" ".equals(nom) && nom.length() >= 2)
	        {
	            FileWriter fr = new FileWriter(repertoire + nomFichier + ".txt",true);
	            fr.write(civilite + "||");
	            fr.write(nom + "||");
	            if(prenom != null)fr.write(prenom + "||");
	            else fr.write(" ||");
	            
	            fr.write(age + "||");            
	            if(adresse != null)fr.write(adresse + "||");
	            else fr.write(" ||");
	            
	            if(email != null)fr.write(email + "||");
	            else fr.write(" ||");
	            
	            if(niveau != null)fr.write(niveau + "\r\n");
	            else fr.write(" \r\n");
	            //fermeture du flux
	            fr.close();         
	        }        
	        
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet ServletExercice12</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<center><h3>Informations sur le traitement de la servlet</h3></center>");
	        if(nomFichier != null && nom != null && !" ".equals(nom) && nom.length() >= 2)
	            out.println("Données enregistrées avec succès ...");
	        else out.println("Echec lors de l'enregistrement des données transmises !!!");
	        out.println("</body>");
	        out.println("</html>");        
	        out.close();
	    }catch(Exception ex)
	    {
	        
	    }
	  }

    /** description de la servlet. */
    public String getServletInfo() { return "ServletExercice12";  }


}
