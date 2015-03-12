package paquet;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contact
 *
 */
@Entity
public class Contact implements Serializable {

	
	private String nom;
	private String adresse;
	private static final long serialVersionUID = 1L;

	public Contact() {
		super();
	}   
	@Id    
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
   
}
