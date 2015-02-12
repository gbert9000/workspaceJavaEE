package com.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.client.Proverbe;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Prov2 implements EntryPoint  {
    private static final String SERVER_ERROR = "Impossible d'établir la connexion avec le serveur.";
    
    private final ProverbesServAsync proverbesService = GWT.create(ProverbesServ.class);
    
    private HTML prov, orig, err;

	DockLayoutPanel panelBase;
	DeckLayoutPanel content1;
	DeckLayoutPanel content2;
	Grid panelMenu;
	Button b1, b2;

    public void onModuleLoad() {
    	
    	panelBase = new DockLayoutPanel(Unit.EM);
		content1 = new DeckLayoutPanel();
		content2 = new DeckLayoutPanel();
		panelMenu = new Grid(2,1);
		b1 = new Button("Création");
		b2 = new Button("Affichage");
		panelMenu.setWidget(0, 0, b1);
		panelMenu.setWidget(1, 0, b2);
		content1.add(new HTML("<h2> Création </h2><p>Contenu...à créer 2 TextBox, 1 Bouton Ajouter Proverbes...</p>"));
		//content2.add(new HTML("<h2> Section 2</h2><p>La suite Cumque ...</p>"));
		content1.showWidget(0);
		panelBase.addNorth(new HTML("<h1>Application de création de Proverbes</h1>"), 10);
		panelBase.addWest(panelMenu, 10);
    	
    	//content2 = Section Proverbes
		proverbesService.getProverbe(new provCallBack());
		Button b = new Button("Nouveau proverbe", new provClickHandler());
	
		prov = new HTML("Attente du serveur");
		orig = new HTML("Attente du serveur");
		err = new HTML();
		content2.add(b);
		content2.add(prov);
		content2.add(orig);
		content2.add(err);

		//ajout des composants
		panelBase.add(content1);
		panelBase.add(content2);
		//création du panelBase
		RootLayoutPanel.get().add(panelBase);	

    }

    private class provClickHandler implements ClickHandler {
	public void onClick(ClickEvent evt) {
		if (evt.getSource() == b1)
		content1.showWidget(0);
		else if (evt.getSource()== b2) 
		content2.showWidget(1);
		proverbesService.getProverbe(new provCallBack());	    
	}
    }

    /* AsyncCallback interface*/
    private class provCallBack implements AsyncCallback<Proverbe> {
	public void onFailure(Throwable caught) {
	    err.setText(SERVER_ERROR + caught.toString());
	}
    
	public void onSuccess(Proverbe proverbe) {	
	    prov.setText(proverbe.getPhrase());
	    orig.setText(proverbe.getOrigine());
	}
    }
}
