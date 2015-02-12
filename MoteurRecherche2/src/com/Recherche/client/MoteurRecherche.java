package com.Recherche.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;

public class MoteurRecherche implements EntryPoint, ClickHandler {
	private TextBox recherche = new TextBox();
	private ListBox moteur = new ListBox();
	private Button chercher = new Button("Chercher");
	private List<Moteur> moteurs;
	private List<RadioButton> radios = new ArrayList<>();

	public void onModuleLoad() {
		chercher.addClickHandler(this);
		moteur.addItem("Google");
		moteur.addItem("Yahoo!");
		moteur.addItem("Bing");
		moteur.setVisibleItemCount(1);
        RadioButton web = new RadioButton("searchGroup", "Web");
        RadioButton image = new RadioButton("searchGroup", "Images");
        RadioButton news = new RadioButton("searchGroup", "News");
        web.setValue(true);
        radios.add(web);
        radios.add(image);
        radios.add(news);
		RootPanel.get("recherche").add(recherche);
		RootPanel.get("moteur").add(moteur);
		RootPanel.get("options").add(web);
		RootPanel.get("options").add(image);
		RootPanel.get("options").add(news);
		RootPanel.get("chercher").add(chercher);
		moteurs = new ArrayList<Moteur>();
		moteurs.add(new Moteur("Google", "https://www.google.fr/?#q=", "https://www.google.fr/search?tbm=isch&q=","https://www.google.fr/search?tbm=nws&q="));
		moteurs.add(new Moteur("Yahoo!", "https://fr.search.yahoo.com/search?q=", "https://fr.images.search.yahoo.com/search/images?q=","https://fr.news.search.yahoo.com/search?q="));
		moteurs.add(new Moteur("Bing", "http://www.bing.com/search?q=", "http://www.bing.com/images/search?q=","http://www.bing.com/news/search?q="));
	}
	
	@Override
	public void onClick(ClickEvent event) {
		String recherche = this.recherche.getText();
		Moteur moteur = null;
		String option = null;
		StringBuilder sb = new StringBuilder();
		for(Moteur mot:moteurs) {
			if(this.moteur.getValue(this.moteur.getSelectedIndex()).equals(mot.getNom()))
				moteur = mot;
		}
		for(RadioButton radio:radios) {
			if(radio.getValue())
				option = radio.getText();
		}
		if(option.equals("Web"))
			sb.append(moteur.getWebSearch());
		else if(option.equals("Images"))
			sb.append(moteur.getImgSearch());
		else if(option.equals("News"))
			sb.append(moteur.getNewsSearch());
		sb.append(recherche.replace(" ", "+"));
		Window.open(sb.toString(),"_blank","");
	}
}