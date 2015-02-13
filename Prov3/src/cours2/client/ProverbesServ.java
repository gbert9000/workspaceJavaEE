package cours2.client;

import cours2.client.Proverbe;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * ETAPE 1 =
 * The client-side stub for the RPC service. Méthodes appelées par le client ici, soit getProverbe() (renvoi un proverbe), 
 * soit addProverbe(Proverbe p) (ne renvoit rien) ces méthodes sont redéfinies dans ProverbesServImpl.
 */
@RemoteServiceRelativePath("provServ")
public interface ProverbesServ extends RemoteService {
    public Proverbe getProverbe();
    public void addProverbe(Proverbe p);
}
