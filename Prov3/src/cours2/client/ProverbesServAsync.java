package cours2.client;

import cours2.client.Proverbe;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ETAPE 2 =
 * The async counterpart of <code>ProverbesServ</code>. Contrepartie asynchrone de l'interface de service
 * ProverbesServ.java, permet de gérer les envois et retours des requêtes => déclaration des types AsyncCallback<T>.
 */
public interface ProverbesServAsync {
    public void getProverbe(AsyncCallback<Proverbe> cb);
    public void addProverbe(Proverbe nouvP, AsyncCallback<Void> cb);
}
