package paquet;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculBean
 */
//composant local et sans mémoire (Stateless)

//@Stateless(mappedName="SomeJNDIName")
@Stateful
@LocalBean
public class CalculBean implements Calcul {

	
	private int compteur;
	
    /**
     * Default constructor. 
     */
    public CalculBean() {
        compteur=0;
    }

	@Override
	public double somme(double a, double b) {
		// implémentation de la méthode de l'interface
		return a+b;
	}

	public int getCompteur(){
		compteur++;
		return compteur;
	}
}
