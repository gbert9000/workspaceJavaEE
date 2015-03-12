package paquet;

import javax.ejb.Remote;

//interface nommée par défaut CalculBeanRemote
//ici, on rajoute les compétences publiques du composant

@Remote
public interface Calcul {

	//ex: un calcul
	public double somme (double a, double b);

	public int getCompteur();
	
}
