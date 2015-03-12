package metier;

import java.util.Collection;

import javax.ejb.Remote;

import donnees.Personne;

@Remote
public interface ServicePersonne {
	public void creerPersonne(String nom, int age);
	public Collection<Personne> listePersonnes();
}
