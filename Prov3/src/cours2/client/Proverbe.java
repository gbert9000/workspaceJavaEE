package cours2.client;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Proverbe implements Serializable {
    /**
	 * Les objets que l'on va faire transiter sur le réseau à l'aide des méthodes RPC (getProverbe() et addProverbe())
	 */
	private static final long serialVersionUID = 1L;
	private String phrase;
    private String origine;

    static List<Proverbe> lesProvs = null;
    static Random genR = new Random();

    public Proverbe() {
		phrase = "nil";
		origine= "nil";
    }
    public Proverbe(String phr, String or) {
		phrase = phr;
		origine = or;
    }

    public String getPhrase() {
		genR.nextInt(5);
		return phrase;
    }
    public String getOrigine() {
    	return origine;
    }

    //construction des proverbes (phrase+origine)
    public static void buildProverbes() {
		lesProvs = new ArrayList<Proverbe>();
		String []phrs = {"Un tiens vaut mieux que deux tu l'auras", "Pierre qui roule n'amasse pas mousse", "À bon chat, bon rat", "À chaque jour suffit sa peine"};
		String []origs = {"Limousin", "Bretagne", "Lyon", "Paris"};
		int i = 0;
		for (i = 0; i < phrs.length; i++) {
		    lesProvs.add(new Proverbe(phrs[i], origs[i]));
		}
    }
    //ajout de proverbe p à l'ArrayList
    public static void addProverbe(Proverbe p) {
    	lesProvs.add(p);
    }
    //parcours des Proverbes
    public static Proverbe getNextProverbe() {
		if (lesProvs == null) {
		    buildProverbes();
		}
		return lesProvs.get(genR.nextInt(lesProvs.size()));
	}
}