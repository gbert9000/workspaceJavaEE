package com.convertisseur.client;

public class Devise {
    private String abbrev;
    private String nomComplet;
    private double taux;

    public Devise(String ab, String nom, double t) {
	abbrev = ab;
	nomComplet = nom;
	taux = t;
    }

    public String getAbbreviation() {
	return abbrev;
    }
    public String getNomComplet() {
	return nomComplet;
    }
    public double getTaux() {
	return taux;
    }

    public double convertitVers(Devise d, float qtt) {
	return (qtt / taux) * d.getTaux();
    }
    
}