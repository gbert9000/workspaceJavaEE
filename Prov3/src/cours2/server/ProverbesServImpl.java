package cours2.server;

import cours2.client.ProverbesServ;
import cours2.client.Proverbe;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
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
