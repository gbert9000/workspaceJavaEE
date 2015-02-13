package cours2.server;

import cours2.client.ProverbesServ;
import cours2.client.Proverbe;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * ETAPE 3 =
 * The server-side implementation of the RPC service.
 * implémentation du service = méthodes getProverbe() et addProverbe() sont redéfinies (implémentation de l'interface ProverbesServ)
 */
@SuppressWarnings("serial")
public class ProverbesServImpl extends RemoteServiceServlet implements ProverbesServ {
    public Proverbe getProverbe() {
    	return Proverbe.getNextProverbe();
    }
    public void addProverbe(Proverbe p) {
    	Proverbe.addProverbe(p);
    }
}
