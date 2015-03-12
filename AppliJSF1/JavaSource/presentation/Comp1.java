package presentation;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Comp1 {
	//les propriétes du Bean en private
	private String nom;
	private Integer age; //age en String parceque IHM zone de saisie de Texte (c'est le code métier que va convertir)
	
	private boolean majeur;
	
	//les getters et setters (clic droit sur les propriétés > source > generate getters and setters)
	public String getNom() {
		return nom;
	}
	
	public void setMajeur(boolean majeur){
		this.majeur=majeur;
	}
	
	public boolean getMajeur(){
		return majeur;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		majeur=(age>18); //if age > 18 majeur = true else majeur = false ...
		this.age = age;
	}

	//méthode publique = traitements
	public String faire(){
		
		if(nom.equals("Bill Gates"))
			return "erreur";
		
 	//return "pages/inputname"; //renvoi sur la page inputname.xhtml
		return "/resultat"; //pages où l'on récupère les saisies
		//return "ChaineResultat"; //redirection définie dans faces-config.xml cas fréquent l'outcome est le nom de la page...
		
	}
	
}
