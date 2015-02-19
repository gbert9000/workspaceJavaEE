package coreservlets.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.ui.SuggestOracle;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("complete")
public interface CompleteService extends RemoteService {
  SuggestOracle.Response getSuggestions(SuggestOracle.Request r);
}
