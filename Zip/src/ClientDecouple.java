
public class ClientDecouple {

	void action(){
		//passage via la fabrique (factory) = ind�pendance du code 
		ServiceIF s = ServiceNT.fabrique();
		s.faire();
		s.faire();
		s.faire();
		s.faire();
		s.faire();
	}
	
}
