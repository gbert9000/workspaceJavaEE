
public class ClientCouple {

	void action(){
		//dépendance du code forte
		Service s = new Service();
		s.faire();
		s.faire();
		s.faire();
		s.faire();
		s.faire();
		
	}
	
}
