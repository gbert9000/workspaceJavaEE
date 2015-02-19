package coreservlets.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Villes {
    private ArrayList<String> noms;
    private int nbVilles;
    private static Villes inst = null;

    private Villes() {
	noms = new ArrayList<String>();
	nbVilles = 0;
	try {
	    FileInputStream fr = new FileInputStream("./communes.csv");
	    BufferedReader br = new BufferedReader(new InputStreamReader(fr, "UTF-8"));
	    String ville = br.readLine();
	    while (ville != null) {
		nbVilles++;
		noms.add(ville);
		ville = br.readLine();
	    }
	} catch (Exception e) {
	    System.out.println("IOErreur dans Villes.build.");
	    System.out.println(e.toString());
	    return;
	}
	Collections.sort(noms);
    }

    public ArrayList<String> getVillesCommenceOld(String match, int nbMax) {
	ArrayList<String> result = new ArrayList<String>();
	int i = 0, debut = -1, comp;
	boolean found = false;
	String courant;

	while (!found && i < nbVilles) {
	    try {
		courant = noms.get(i).substring(0, match.length());
	    } catch (Exception e) {
		courant = noms.get(i);
	    }	    
	    comp = courant.compareToIgnoreCase(match);
	    if (comp == 0) {
		debut = i;
		found = true;
	    } else i++;
	}
	if (!found) return result;
	else {
	    while (found && i < nbVilles && (i - debut) < nbMax) {
		try {
		    courant = noms.get(i).substring(0, match.length());
		} catch (Exception e) {
		    courant = noms.get(i);
		}	    
		comp = courant.compareToIgnoreCase(match);
		if (comp == 0) {
		    result.add(noms.get(i));
		    i++;
		} else found = false;
	    }
	    return result;
	}
    }

    public ArrayList<String> getVillesCommence(String match, int nbMax) {
	ArrayList<String> result = new ArrayList<String>();
	boolean found = false;
	String courant = null;
	int debut, fin;
	debut = fin = 0;
	int i = nbVilles/2, premier = 0, dernier = nbVilles, comp;
	while (!found && premier <= dernier) {
	    try {
		courant = noms.get(i).substring(0, match.length());
	    } catch (Exception e) {
		courant = noms.get(i);
	    }
	    comp = courant.compareToIgnoreCase(match);
	    if (comp == 0) {
		debut = i;
		found = true;
	    } else if (comp < 0) {
		premier = i + 1;
	    } else {
		dernier = i - 1;
	    }
	    i = (premier + dernier) /2;
	}
	//Recupère la premiere ville
	while (found && debut >= 0) {
	    try {
		courant = noms.get(debut).substring(0,match.length());
	    } catch (Exception e) {
		courant = noms.get(debut);
	    }
	    comp = courant.compareToIgnoreCase(match);
	    if (comp == 0) {
		debut--;
	    } else found = false;
	}
	
	fin = ++debut;
	found = true;
	while (found && fin < nbVilles && (fin - debut) < nbMax) { 
	    try {
		courant = noms.get(fin).substring(0,match.length());
	    } catch (Exception e) {
		courant = noms.get(fin);
	    }
	    comp = courant.compareToIgnoreCase(match);
	    if (comp == 0) {
		result.add(noms.get(fin));
		fin++;
	    } else found = false;
	}
	return result;
    }

    public static Villes getVilles() {
	if (inst == null) inst = new Villes();
	return inst;
    }

    /*
    public static void main(String []args) {
	build();
	String [] tests = {"aa", "bast", "aaaaa", "zzzzz", "gi", "kjb", "toulo", "zu"};
	for (String rech : tests) {
	    List<String> r = getVillesCommence(rech, 20);
	    System.out.println(rech + " :");
	    for (String s : r) {
		System.out.println(s);
	    }
	}
    }
    */
}