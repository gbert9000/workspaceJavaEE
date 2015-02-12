package com.Recherche.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.Window.*;


public class MoteurRecherche implements EntryPoint, ClickHandler {
	
	/* Attributs */
	private TextBox requete;
	private ListBox moteur;
	private Button chercher;
	private RadioButton web;
	private RadioButton images;
	private RadioButton news;
	private static final List<Moteur> TAB_MOTEURS = new ArrayList<Moteur>();
	
	static{
		String noms[] = {"Google", "Bing", "Yahoo", "DuckDuckGo"};
		
		String webUrls[] = {"https://www.google.fr/?gws_rd=ssl#q=", "http://www.bing.com/search?q=",
			           "https://fr.search.yahoo.com/search;_ylt=AjoUuwv0nb_Sw8QJ0DZ0iD5NhJp4?p=",
			           "https://duckduckgo.com/?q="};
		
		String imageUrls[] = {"https://www.google.fr/search?q=", "http://www.bing.com/images/search?q=",
			             "https://fr.images.search.yahoo.com/search/images;_ylt=A9mSs2r7XdVUFisA3a1jAQx.?p=",
			             "https://duckduckgo.com/?q="};
	
		String imageUrlSuffixes[] = {"&biw=1920&bih=995&source=lnms&tbm=isch", "&FORM=HDRSC2", "&fr=yfp-t-905&fr2=piv-web", "&iax=1&ia=images"};
			
		String newsUrls[] = {"https://www.google.fr/?gws_rd=ssl#q=", "http://www.bing.com/news/search?q=",
						"https://fr.news.search.yahoo.com/search;_ylt=Az_6xdb_XdVU5AkADxZlAQx.?p=",
						"https://duckduckgo.com/?q="};
	
		String newsUrlSuffixes[] = {"&tbm=nws", "&FORM=HDRSC6", "&fr=yfp-t-905&fr2=piv-web", "&ia=news"};
	
		for(int i = 0; i<noms.length; i++){
			TAB_MOTEURS.add(new Moteur(noms[i], webUrls[i], imageUrls[i], imageUrlSuffixes[i], newsUrls[i], newsUrlSuffixes[i]));
		}
	}
	
	public void onModuleLoad() {
		requete = new TextBox();
		moteur = new ListBox();
		chercher = new Button("GO");
		web = new RadioButton("radioGroup","Web");
		images = new RadioButton("radioGroup","Images");
		news = new RadioButton("radioGroup","Actualites");
		
		initListBox();		

		chercher.addClickHandler(this);
		
		RootPanel.get("query").add(requete);
		RootPanel.get("engine").add(moteur);
		RootPanel.get("search").add(chercher);
		RootPanel.get("web").add(web);
		RootPanel.get("images").add(images);
		RootPanel.get("news").add(news);
		requete.setFocus(true);
		web.setValue(true);
	}

	@Override
	public void onClick(ClickEvent event) {
		String rqt = requete.getText();
		String engine = moteur.getItemText(moteur.getSelectedIndex());
		Boolean w, i, n;
		
		w=web.getValue();
		i=images.getValue();
		n=news.getValue();
		
		try
		{
			for (Moteur m : TAB_MOTEURS) {
				if (m.getNom().equals(engine)) {
					if(w){
						Location.assign(m.constructRqtWeb(rqt));
					}
					if(i){
						Location.assign(m.constructRqtImages(rqt));
					}
					if(n){
						Location.assign(m.constructRqtNews(rqt));
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("<p style=\"color: red\">" + e.toString()+ "<p/>");
		}
	}

	private void initListBox (){
		for (Moteur m : TAB_MOTEURS)
		{
			moteur.addItem(m.getNom());
		}
	}
	
}
