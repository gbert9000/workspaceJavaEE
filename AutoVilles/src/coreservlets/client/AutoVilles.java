package coreservlets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.RootPanel;


public class AutoVilles implements EntryPoint {
    private static final String SERVER_ERROR = "An error occurred while "
	+ "attempting to contact the server. Please check your network "
	+ "connection and try again.";
    
    private final CompleteServiceAsync completeProxy = GWT.create(CompleteService.class);
    
    
    public void onModuleLoad() {
	NetSuggestOracle so = new NetSuggestOracle(10, completeProxy);
	SuggestBox sb = new SuggestBox(so);
	
	RootPanel.get("autoID").add(sb);
    }
}

/*
	so.add("Foix");
	so.add("Tarbes");
	so.add("Toulouse");
	so.add("Nantes");
	so.add("Lyon");
	so.add("Millau");
	so.add("Tonerre");
	so.add("Tavel");
*/