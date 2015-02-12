package com.convertisseur.client;

import com.convertisseur.client.Devise;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Convertisseur implements EntryPoint {
	private TextBox quantite; //valeur saisie
	private ListBox source; //devise à convertir
	private ListBox destination; // devise de destination (taux)
	private Button calculer; //bouton handler
	private double result; //affichage résultat
	private List<Devise> lesDevises; //liste des devises
	
	static final String []noms={"EUR","USD","CHF","GPB"};
	static final Double[]taux={1.0,1.13431,0.92453,1.52623};
	
	public void initDevises(){
		int i;
		ArrayList<Devise> lesDevises = new ArrayList<Devise>();
		
		for (i=0;i<noms.length;i++){
			lesDevises.add(new Devise(noms[i],taux[i]));
		}
		
		for (Devise dev:lesDevises){
			source.addItem(dev.getNom());
			destination.addItem(dev.getNom());
		}
		
	}
	
	public void onModuleLoad() {
		quantite = new TextBox();
		source = new ListBox();
		destination = new ListBox();
		calculer = new Button("Calculer");
		result = new HTML();

		//initialisation
		quantite.getElement().setPropertyString("palceholde", "entrez le montant");
		initDevises();

		RootPanel.get("quantite").add(quantite);
		RootPanel.get("sourceDevise").add(source);
		RootPanel.get("destinationDevise").add(destination);
		RootPanel.get("calcul").add(calculer);
		RootPanel.get("result").add(result);
		quantite.setFocus(true);

		//traitement
		calculer.addClickHandler(new Calcule());
	}

	private class Calcule implements ClickHandler{
		
		public void onClick(ClickEvent evt) {
			//RootPanel.get("resultat");
			double affiche;
			Double valeur;
			String aConvertir = source.getSelectedValue();
			String versDevise = destination.getSelectedValue();
			Devise entree;
			Devise sortie;
			
			
			try {
				affiche=entree.convertitVers(sortie, Float.parseFloat(quantite.getValue()));
				result.setHTML("Résultat : " + String.valueOf(affiche)); //pas de toString sur types primitifs...
				}
				catch (Exception e) {
				result.setHTML("<p style=\"color: red\">" + e.toString()+ "<p/>");
			}
		}
	
	}	
	
}