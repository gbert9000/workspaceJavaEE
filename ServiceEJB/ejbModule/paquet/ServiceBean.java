package paquet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ServiceBean
 */
//soit Stateless, Stateful, soit Singleton
@Stateless
@LocalBean
public class ServiceBean implements ServiceBeanRemote {

    /**
     * Default constructor. 
     */
    public ServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String salutation(String qui) {
		// TODO Auto-generated method stub
		return qui;
	}

}
