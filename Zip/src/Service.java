
public class Service implements ServiceIF {

	public void faire(){
		//code d�pend d'une techno
		
	}
	
	public static ServiceIF fabrique(){
		return new Service();
	}
	
}
