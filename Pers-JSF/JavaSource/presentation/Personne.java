package presentation;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import metier.ServicePersonne;


@ManagedBean
public class Personne {

	@EJB
	ServicePersonne svp;
	
	private String nom;
	private Integer age;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String creerPersonne(){ //méthode appelée par l'action JSF personne.creerPersonne
		svp.creerPersonne(nom, age); //appel de la méthode de l'EJB
		return "/Success"; //renvoie un outcome "Success"
	}
	
	public Collection<donnees.Personne> getListe(){
		return svp.listePersonnes();
		
	}
/*	Attention aux types de données renvoyées, ici on veut les Personne du package donnees (Projet Pers-EJB)
 * Si l'on met Collection<Personne> on ne fait pas référence à la bonne classe Personne
 * il fait une collection de lui-même... cela met un warning */
	
}
