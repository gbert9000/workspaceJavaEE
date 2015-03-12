package presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//connection au service de messagerie JMS
		
		try {
			//1> pour travailler dans un annuaire (JNDI) il faut récupérer un contexte
			Context contexte = new InitialContext();
			//2> interface vers le service de messagerie, récupération de la référence JNDI du service de messagerie (/ConnectionFactory)
			ConnectionFactory serviceMessagerie = (ConnectionFactory)contexte.lookup("/ConnectionFactory");
			//3> création d'une connection sur la messagerie
			Connection conn = serviceMessagerie.createConnection();
			//4> Dans la connection, création d'une session
			Session session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
			//5> on récupère la queue dans laquelle on envoie le message
			Queue queue = (Queue)contexte.lookup("java:/jms/queue/MessMQ");

			//6> Création d'un producteur de message
			MessageProducer producteur = session.createProducer(queue);
			//7.Message=
				//démarrage de connection	
				conn.start();
				//edition de message
				TextMessage message = session.createTextMessage("Bonjour");
				//envoi de message
				producteur.send(message);
				//fermeture
				conn.close();
			
			//log/debug
			out.println("Message envoyé !");
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
