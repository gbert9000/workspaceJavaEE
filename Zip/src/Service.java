
public class Service implements ServiceIF {

	public void faire(){
		//code dépend d'une techno
		
	}
	
	public static ServiceIF fabrique(){
		return new Service();
	}
	
}
