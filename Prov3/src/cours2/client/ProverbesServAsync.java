package cours2.client;

import cours2.client.Proverbe;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>ProverbesServ</code>.
 */
public interface ProverbesServAsync {
    public void getProverbe(AsyncCallback<Proverbe> cb);
    public void addProverbe(Proverbe nouvP, AsyncCallback<Void> cb);
}
