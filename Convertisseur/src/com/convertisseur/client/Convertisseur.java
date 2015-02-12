package com.convertisseur.client;

import com.convertisseur.client.Devise;
import java.util.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Convertisseur implements EntryPoint {
    static final String nomsDevises[][] = {{"EUR", "Euro européen"}, 
			      {"USD", "Dollar américain"}, 
			      {"CZK", "Couronne tchèque"}, 
			      {"RUB", "Rouble russe"}, 
			      {"GPB", "Livre Britannique"}, 
			      {"SYP", "Livre syrienne"}};
    static final double tauxDevise[] = {1, 1.14, 27.7, 75.67, 0.75, 215.86};

    ListBox devEntree, devSortie;
    TextBox qtt;
    Button calcule;
    HTML resultat;
    List<Devise> lesDevises;
    
    public void initDevises() {
	int i;
	Devise d;
	lesDevises = new ArrayList<Devise>();

	for (i = 0; i < tauxDevise.length; i++) {
	    d = new Devise(nomsDevises[i][0], nomsDevises[i][1], tauxDevise[i]);
	    lesDevises.add(d);
	}

	for (Devise dev : lesDevises) {
	    devEntree.addItem(dev.getAbbreviation() + " - " 
			      + dev.getNomComplet(), dev.getAbbreviation());
	    devSortie.addItem(dev.getAbbreviation() + " - " 
			      + dev.getNomComplet(), dev.getAbbreviation());
	}
    }

    public void onModuleLoad() {
	devEntree = new ListBox();
	devSortie = new ListBox();
	calcule = new Button("Calculer");
	qtt = new TextBox();
	resultat = new HTML();

	qtt.getElement().setPropertyString("placeholder", "Entrez le montant");
	initDevises();

	RootPanel.get("qttID").add(qtt);
	RootPanel.get("entreeID").add(devEntree);
	RootPanel.get("sortieID").add(devSortie);
	RootPanel.get("calculerID").add(calcule);
	RootPanel.get("resultatID").add(resultat);

	calcule.addClickHandler(new Calcule());
    }

    private class Calcule implements ClickHandler {

	public void onClick(ClickEvent evt) {
	    int i = 0;
	    Devise de = null, ds = null, dc;
	    boolean trouveE = false, trouveS = false;
	    String devE = devEntree.getSelectedValue();
	    String devS = devSortie.getSelectedValue();
	    Double result;

	    while (!(trouveE && trouveS) && i < lesDevises.size()) {
		dc = lesDevises.get(i); 
		if (dc.getAbbreviation().equals(devE)) {
		    de = dc;
		    trouveE = true;
		}
		if (dc.getAbbreviation().equals(devS)) {
		    ds = dc;
		    trouveS = true;
		}
		i++;
	    }
	    if (!(trouveE && trouveS)) {
		GWT.log("Devise inconnue!");
	    } else {
		try {
		    result = de.convertitVers(ds, Float.parseFloat(qtt.getValue())); 
		    resultat.setHTML(((Double)result).toString());
		} catch (Exception e) {
		    resultat.setHTML("Entrez un nombre bien formé");
		}
	    }
	}
    }
}
