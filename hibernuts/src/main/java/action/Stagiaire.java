package action;

import java.util.Date;

public class Stagiaire {
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private String password;
	private Date inscription;
	
	public Stagiaire() {}
	
	public Stagiaire(String nom, String prenom, String email, String password) {
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setPassword(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getInscription() {
		return inscription;
	}
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

}
