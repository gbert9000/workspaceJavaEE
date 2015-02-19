package coreservlets.client;

import coreservlets.client.CompleteServiceAsync;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class NetSuggestOracle extends SuggestOracle {
    int limite;
    CompleteServiceAsync prox;

    public NetSuggestOracle(int lim, CompleteServiceAsync p) {
	limite = lim;
	prox = p;
    }

    public boolean isDisplayStringHTML() {
	return true;
    }
    public void requestDefaultSuggestions(SuggestOracle.Request request,
					  SuggestOracle.Callback callback) {
	callback.onSuggestionsReady(request, new Response());
    }

    public void requestSuggestions(Request r, Callback cb) {
	prox.getSuggestions(r, new SuggCallback(r, cb));
    }

    private class SuggCallback implements AsyncCallback<Response> {
	private Request req;
	private Callback cb;
	public SuggCallback(Request r, Callback c) {
	    req = r;
	    cb = c;
	}
	public void onFailure(Throwable t) {
	    cb.onSuggestionsReady(req, new Response());	    
	}

	public void onSuccess(Response resp) {
	    cb.onSuggestionsReady(req, resp);
	}
    }
}