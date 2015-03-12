package donnees;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity
@Table(schema="jpa")
public class Personne implements Serializable {


	@Id
	private String nom;
	private int age;
	private static final long serialVersionUID = 1L;

	public Personne() {
		super();
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
   
}
