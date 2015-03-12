
public class ClientDecouple {

	void action(){
		//passage via la fabrique (factory) = indépendance du code 
		ServiceIF s = ServiceNT.fabrique();
		s.faire();
		s.faire();
		s.faire();
		s.faire();
		s.faire();
	}
	
}
