package utils;

import java.io.Serializable;
import java.lang.String;

public class Etudiant implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//attributs de l'eleve
    protected long idEleve = 0L;
    protected String nom = null;
    protected String prenom = null;
    protected int age ;
    protected String adresse = null;
    protected String email = null;
    
    /** Constructeur par defaut de la classe Eleve */
    public Etudiant(){ }
    
    //definition des accesseurs de la classe
    public long getIdEleve(){return idEleve ;}
    public void setIdEleve(long id){idEleve = id;}
    
    public String getNom(){return nom ;}
    public void setNom(String n){nom = n;}
    
    public String getPrenom(){return prenom ;}
    public void setPrenom(String pn){prenom = pn;} 
    
    public int getAge(){return age ;}
    public void setAge(int ag){age = ag;}  
    
    public String getAdresse(){return adresse ;}
    public void setAdresse(String adrs){adresse = adrs;}
    
    public String getEmail(){return email ;}
    public void setEmail(String mail){email = mail;}  
    
}
