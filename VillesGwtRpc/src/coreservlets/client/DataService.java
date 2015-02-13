package coreservlets.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("data-service")
public interface DataService extends RemoteService {
  public String getButton1Data();
  public String[] getButton2Data();
  public RandomNumber getButton3Data(String range);
  public void logClientRandom(RandomNumber clientRandom);
}