package metier;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import donnees.Personne;

/**
 * Session Bean implementation class PersonneBean
 */
@Stateless
@LocalBean
public class ServicePersonneBean implements ServicePersonne {

    /**
     * Default constructor. 
     */
    public ServicePersonneBean() {
    }

    @PersistenceContext
    EntityManager em; //@PersistenceContext = injection de dépendance (comme @EJB)
    //permet de transformer en ordre SQL dans la couche de persistence
    
	@Override
	public void creerPersonne(String nom, int age) {
		Personne lui = new Personne();
		lui.setNom(nom);
		lui.setAge(age);
		em.persist(lui); //~insert into de SQL
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Personne> listePersonnes() {
		return em.createQuery("FROM Personne").getResultList(); //~select * from personne de SQL
	}

}
