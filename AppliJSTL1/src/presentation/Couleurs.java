package presentation;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Couleurs {

	private final String[] couleurs= {"Rouge", "Bleu", "Vert"};

	
	public String[] getCouleurs() {
		return couleurs;
	}
	
}
