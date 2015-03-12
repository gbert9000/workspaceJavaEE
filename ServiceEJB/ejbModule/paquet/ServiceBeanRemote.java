package paquet;

import javax.ejb.Remote;

@Remote
public interface ServiceBeanRemote {
	
	public String salutation(String qui);
}
