package coreservlets.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SuggestOracle;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface CompleteServiceAsync {
    void getSuggestions(SuggestOracle.Request req, 
			AsyncCallback<SuggestOracle.Response> resp);
}
