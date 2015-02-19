package coreservlets.server;

import java.util.ArrayList;
import coreservlets.server.Villes;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import coreservlets.client.CompleteService;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Response;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;
/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CompleteServiceImpl extends RemoteServiceServlet 
    implements CompleteService {
    //private static Villes villes;

    public SuggestOracle.Response getSuggestions(SuggestOracle.Request r) {
	Villes villes = Villes.getVilles();
	ArrayList<String> villesRes;
	ArrayList<Suggestion> lesSug = new ArrayList<Suggestion>();
	
	villesRes = villes.getVillesCommence(r.getQuery(), 10);
	for (String v : villesRes) {
	    String v2 = "<b>" + v.substring(0, r.getQuery().length()) 
		+ "</b>"+ v.substring(r.getQuery().length());
	    lesSug.add(new MultiWordSuggestion(v, v2));
	}
	
	return new Response(lesSug);
    }
}
