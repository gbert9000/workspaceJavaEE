package metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import donnees.Personne;

/**
 * Session Bean implementation class ServicePersonneBean
 */
@Stateless
@LocalBean
public class ServicePersonneBean implements ServicePersonne {

    /**
     * Default constructor. 
     */
    public ServicePersonneBean() {
        // TODO Auto-generated constructor stub
    }

    //unitName déclaré dans persistence.xml
    @PersistenceContext(unitName="DonneesDS")
    EntityManager em;
    
    @Override
	public void creer(String nom, int age){
	
    	//Crée une instance de l'entity JPA
		Personne lui = new Personne ();
		lui.setNom(nom);
		lui.setAge(age);
		//Crée un nouvel objet dans la database (enregistrement dans table)
		em.persist(lui);
		
	}
    
    //Recherche l'age d'une personne
    @Override
    public int donneAge(String nom){
    	Personne cherchee = em.find(Personne.class, nom);
    	if(cherchee != null)
    		return cherchee.getAge();
    	else
    		return 0;
    }
    
    //Retourne la liste des personnes
    @Override
    public List<Personne> listePersonnes(){
    	Query req = em.createQuery("FROM Personne"); //langage ~SQL
    	return req.getResultList();
    }
    
}
