package metier;

import java.util.List;

import javax.ejb.Remote;

import donnees.Personne;

@Remote
public interface ServicePersonne {

	public void creer(String nom, int age);
	public int donneAge(String nom);
	public List<Personne> listePersonnes();
}
