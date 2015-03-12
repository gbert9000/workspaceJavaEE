package presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ServicePersonne;

/**
 * Servlet implementation class CreerPers
 */
@WebServlet("/CreerPers")
public class CreerPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerPers() {
        super();
        // TODO Auto-generated constructor stub
    }

    @EJB
    ServicePersonne svc;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Servlet d'action qui ne renvoie rien, on a juste un formulaire qui créer des personnes.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String age = request.getParameter("age");
		if(nom != null && age != null)
		
		try {
				int lage = Integer.parseInt(age);	
				svc.creerPersonne(nom, lage);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html><body><h1>Saisie de l'age invalide</h1>");
		}

		//forward vers la servlet de presentation (liste de personnes)
		getServletContext().getRequestDispatcher("/ListerPers").forward(request, response);
		
/*		PrintWriter out = response.getWriter();
		out.print("<html><body><h2>Personne = "+nom+" créée !</h2>");
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
