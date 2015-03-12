package presentation;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Comp1 {
	//les propri�tes du Bean en private
	private String nom;
	private Integer age; //age en String parceque IHM zone de saisie de Texte (c'est le code m�tier que va convertir)
	
	private boolean majeur;
	
	//les getters et setters (clic droit sur les propri�t�s > source > generate getters and setters)
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

	//m�thode publique = traitements
	public String faire(){
		
		if(nom.equals("Bill Gates"))
			return "erreur";
		
 	//return "pages/inputname"; //renvoi sur la page inputname.xhtml
		return "/resultat"; //pages o� l'on r�cup�re les saisies
		//return "ChaineResultat"; //redirection d�finie dans faces-config.xml cas fr�quent l'outcome est le nom de la page...
		
	}
	
}
