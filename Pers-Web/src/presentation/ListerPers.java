package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donnees.Personne;
import metier.ServicePersonne;

/**
 * Servlet implementation class PersonneServlet
 */
@WebServlet("/ListerPers")
public class ListerPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerPers() {
        super();
        // TODO Auto-generated constructor stub
    }

    @EJB
    ServicePersonne svc; //@EJB = injection de dépendance (comme @PersistenceContext)
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
/*		svc.creerPersonne("bert", 33);
		svc.creerPersonne("katia",34);
		svc.creerPersonne("karim",38);*/
		out.print("<html><body>");
		//out.print("<p>insertion des valeurs</p>");
		
		Collection<Personne> liste = svc.listePersonnes();
		for (Personne personne : liste) {
			out.print("<p>"+personne.getNom()+"<p>");
		}
		
		out.print("<a href='/Pers-Web/index.html'>Créer une nouvelle personne</a>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
