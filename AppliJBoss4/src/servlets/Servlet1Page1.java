package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Servlet1Page1
 */
public class Servlet1Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private int compteur;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1Page1() {
        
    	super();
        System.err.print("Constructeur page 1"); //affichage console en rouge
    	compteur = 0;
    }
    
    public void init(){
    	compteur=33;
        System.err.print("Méthode init page 1");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.println("Texte de la Servlet 1, méthode GET"); //sortie convertie (encodage de la page)
		//out.write("téxte à convertir"); //sortie brute, 2 méthodes de flux sortie pas totalement identiques...
		out.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.println("Texte de la Servlet 1, méthode POST"); //sortie convertie (encodage de la page)
		out.print("Ville = "+request.getParameter("ville"));
		out.print("<br>Pays = " +request.getParameter("pays"));
		//out.write("téxte à convertir"); //sortie brute, 2 méthodes de flux sortie pas totalement identiques...
		out.write("</body></html>");
		
		compteur++;
		out.print("<br>Compteur = " +compteur);
		
		//exemple de variable de session
		Integer cpt;
		cpt= (Integer)request.getSession().getAttribute("cpt");
		if (cpt == null)
			cpt = new Integer(1);

		//on incrémente
		++cpt;			
		
		//on affiche
		out.print("<br>Compteur session = " +cpt);
		//on stocke pour la session
		request.getSession().setAttribute("cpt",cpt);	 
		
		
		
	}

}
