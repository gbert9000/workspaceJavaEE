package cours2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import cours2.client.Proverbe;

/**
 * ETAPE 5 = Utilisation de RPC et des services mis en place
 * Entry point classes define <code>onModuleLoad()</code>. (EntryPoint classe = Equivalent du main dans un programme Java)
 */
public class Prov3 implements EntryPoint  {
    private static final String SERVER_ERROR = "Impossible d'établir la connexion avec le serveur.";
    
    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
   */
    private final ProverbesServAsync proverbesService = GWT.create(ProverbesServ.class);
    
    private TabLayoutPanel tb;
    private Grid pageLire;
    private Grid pageEcrire;

    private TextBox nouvProverbe, nouvOrigine;
    private Button getProverbe, envoyerProverbe;

    private HTML prov, orig, err, errEnregistre;

    public void creePageLire() {
	Grid zoneProv = new Grid(2,2);
	prov = new HTML("Attente du serveur");
	orig = new HTML("Attente du serveur");
	err = new HTML();
	getProverbe = new Button("Nouveau proverbe",  new provClickHandler());
	zoneProv.setText(0, 0, "Proverbe :");
	zoneProv.setWidget(0, 1, prov);
	zoneProv.setText(1, 0, "Origine :");
	zoneProv.setWidget(1, 1, orig);
	
	pageLire = new Grid(3, 1);
	pageLire.setWidget(0, 0, zoneProv);
	pageLire.setWidget(1, 0, getProverbe);
	pageLire.setWidget(2, 0, err);
    }

    public void creePageEcrire() {
	Grid zoneEntrees = new Grid(2,2);
	pageEcrire = new Grid(2,2);
	nouvProverbe = new TextBox();
	nouvOrigine = new TextBox();
	envoyerProverbe = new Button("Enregistrer", new provClickHandler());
	errEnregistre = new HTML();

	zoneEntrees.setText(0, 0,  "Proverbe :");
	zoneEntrees.setWidget(0, 1,  nouvProverbe);
	zoneEntrees.setText(1, 0,  "Origine :");
	zoneEntrees.setWidget(1, 1,  nouvOrigine);
	
	pageEcrire = new Grid(3, 1);
	pageEcrire.setWidget(0, 0, zoneEntrees);
	pageEcrire.setWidget(1, 0, envoyerProverbe);
	pageEcrire.setWidget(2, 0, errEnregistre);
    }

    public void onModuleLoad() {
	tb = new TabLayoutPanel(10, Unit.EM);
	
	creePageLire();
	creePageEcrire();

	proverbesService.getProverbe(new provCallBack());

	tb.add(pageLire, "Lire les proverbes");
	tb.add(pageEcrire, "Ajouter des proverbes");
	RootLayoutPanel.get().add(new HTML("<h1>Lire et créer des proverbes</h1>"));
	RootLayoutPanel.get().add(tb);
    }

    private class provClickHandler implements ClickHandler {
	public void onClick(ClickEvent e) {
	    if (e.getSource() == getProverbe) {
		proverbesService.getProverbe(new provCallBack());
	    } else {
		if (!(nouvProverbe.getValue().equals("") || 
		      nouvOrigine.getValue().equals(""))) {
		    Proverbe p = new Proverbe(nouvProverbe.getValue(), 
					      nouvOrigine.getValue());
		    proverbesService.addProverbe(p, new enrCallback());		
		} else {
		    errEnregistre.setText("Remplir les deux champs svp.");
		}
	    }
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

    private class enrCallback implements AsyncCallback<Void> {
	public void onFailure(Throwable caught) {
	    errEnregistre.setText(SERVER_ERROR + caught.toString());
	}
    
	public void onSuccess(Void v) {	
	    errEnregistre.setText("Proverbe enregistré.");
	}	
    }
}
