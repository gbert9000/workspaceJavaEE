package com.convertisseur.client;

public class Devise {

	private String nom;
	private Double taux;
	
	public Devise(String nom, Double taux){
		setTaux(taux);
		setNom(nom);
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	public Double getTaux(){
		return taux;
	}
	
	public void setTaux(Double taux){
		this.taux=taux;
	}
	
	public double convertitVers(Devise d, float quantite){
		return (quantite/taux)*d.getTaux();
	}
	
}
