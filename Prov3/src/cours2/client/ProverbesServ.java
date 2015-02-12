package cours2.client;

import cours2.client.Proverbe;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("provServ")
public interface ProverbesServ extends RemoteService {
    public Proverbe getProverbe();
    public void addProverbe(Proverbe p);
}
