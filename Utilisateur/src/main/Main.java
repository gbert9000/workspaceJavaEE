package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import paquet.ServiceBeanRemote;

public class Main {

	public static void main(String[] args) throws NamingException {

		//0. si l'on veut eviter un fichier jndi.properties
		//on créer un fichier Properties prop = new Properties();
		//on le passe en paramètre à InitialContext(prop)
		//on fait des prop.setProperty("key","value"); pour mettre nos propriétés...
		//il existe plusieurs solutions...
		
		//1. recherche dans l'annuaire du composant que l'on veut manipuler
		//référence d'une interface de type Context
		Context annuaire = new InitialContext();
		//recherche dans l'annuaire du nom logique (dans console de déploiement)
		//annuaire.lookup("ClientComposantEAR/Composant/CalculBean!paquet.Calcul");
	
		//2.création du fichier jndi.properties
		//InitialContextFactory; url ; et ejb.context=true
		//le nom et l'endroit du fichier jndi.properties sont important
		//fichier nécessaire à la création du contexte et à l'utilisation d'un annuaire
		
		//3. on rajoute au projet la librairie jboss-client.jar
		//dans Rep wildfly/bin/client
		
		//4. Récupération du client (rajout de la dépendance)
		ServiceBeanRemote personne = (ServiceBeanRemote)annuaire.lookup("ServiceEJB/ServiceBean!paquet.ServiceBeanRemote");
		//System.out.println("Résultat = "+ cal.somme(12,89));
		System.out.println("Salut : "+personne.salutation("Bertrand"));
		
	}

}
