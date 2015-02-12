package com.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.client.Proverbe;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Prov2 implements EntryPoint  {
    private static final String SERVER_ERROR = "Impossible d'établir la connexion avec le serveur.";
    
    private final ProverbesServAsync proverbesService = GWT.create(ProverbesServ.class);
    
    private HTML prov, orig, err;
    public void onModuleLoad() {
	proverbesService.getProverbe(new provCallBack());
	Button b = new Button("Nouveau proverbe", new provClickHandler());

	prov = new HTML("Attente du serveur");
	orig = new HTML("Attente du serveur");
	err = new HTML();
	RootPanel.get("nouvID").add(b);
	RootPanel.get("provID").add(prov);
	RootPanel.get("origID").add(orig);
	RootPanel.get("cont").add(err);
    }

    private class provClickHandler implements ClickHandler {
	public void onClick(ClickEvent e) {
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
