import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import paquet.Calcul;


public class ClientWindows {

	public static void main(String[] args) throws NamingException {

		System.out.println("Bonjour du main");
		
		//1. recherche dans l'annuaire du composant que l'on veut manipuler
		//référence d'une interface de type Context
		Context annuaire = new InitialContext();
		//recherche dans l'annuaire du nom logique (dans console de déploiement)
		//annuaire.lookup("ClientComposantEAR/Composant/CalculBean!paquet.Calcul");
	
		//2.création du fichier jndi.properties
		//InitialContextFactory; url ; et ejb.context=true
		
		//3. on rajoute au projet la librairie jboss-client.jar
		//dans Rep wildfly/bin/client
		
		//4. Récupération du client (rajout de la dépendance)
		Calcul cal = (Calcul)annuaire.lookup("ClientComposantEAR/Composant/CalculBean!paquet.Calcul");
		System.out.println("Résultat = "+ cal.somme(12,89));
		
	}

}
