package paquet;

//exemple de JavaBean
public class DataBean {
	//variables private
	private String donnees;
	
	//constructeur public
	public DataBean(){
		
	}
	
	public String getDonnees(){
		return donnees;
	}
	
	public void setDonnees(String d){
		this.donnees=d;
	}
}
