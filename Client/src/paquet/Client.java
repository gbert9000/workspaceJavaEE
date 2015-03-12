package paquet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

    //Référence vers le stub d'une instance
    //du composant EJB CalculBean (attention au lien buildPath vers le projet EJB)
    @EJB
    private Calcul leCalcul;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//on récupère une sortie vers le client
		PrintWriter out = response.getWriter();
/*		//on récupère la session HTTP
		HttpSession session = request.getSession();
		//on cherche l'attribut"BonDeCommande" lié à la session HTTP
		Calcul localCalcul = (Calcul) session.getAttribute("BonDeCommande");
		
		//Si c'est vide on créer une instance
		if(localCalcul == null)
			try{
				InitialContext context = new InitialContext();
				//localCalcul = (Calcul) context.lookup("ClientComposantEAR/Composant/CalculBean!paquet.Calcul");
				localCalcul = (Calcul) context.lookup("SomeJNDIName");
				session.setAttribute("BonDeCommande", localCalcul);
			}catch(NamingException e){
				throw new ServletException (e);
			}
			
		//on utilise la référence leCalcul vers le EJB
		out.println("Résultat = "+leCalcul.somme(10, 25));
		out.println("Résultat = "+localCalcul.getCompteur());*/
		out.println("Compteur = "+leCalcul.getCompteur());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
