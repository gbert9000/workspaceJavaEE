package paquet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document; //Attention plein de choix d'import pour Document
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.xpath.XPathFactory;

/**
 * Servlet implementation class LireXML
 */
public class LireXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LireXML() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    String ElementText(Node noeud){
    	if(noeud.getNodeType()==Node.ELEMENT_NODE &&
    			noeud.getChildNodes().getLength()==1 &&
    			noeud.getFirstChild().getNodeType()==Node.TEXT_NODE)
    		return noeud.getFirstChild().getNodeValue();
    	else
    		return "";
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//METHODE OLDSCHOOL = recherche des éléments avec position dans le doc XML
		//voir autre METHODE = recherche des éléments avec leurs noms
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		Node n;
		
	
		try {
			String fichier = getServletContext().getRealPath("/cd_catalog.xml");
			//recherche avec syntaxe XPath
			XPath xpath = (XPath) XPathFactory.newInstance().newXPath();
			//Recherche de tous les TITLE dans l'arborescence
			NodeList titres = (NodeList) xpath.evaluate("//TITLE", new InputSource(fichier),XPathConstants.NODESET );
			for( int i=0; i<titres.getLength();i++){
				out.println(ElementText(titres.item(i))+"<br>");
			}
			
			
			
			//Création d'un parser : DocumentBuilder
			//instance d'un DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			//récupération du chemin physique d'un fichier lié au contexte
			//Document doc = parser.parse(getServletContext().getResourceAsStream("cd_catalog.xml")) //autre méthode
			Document doc = parser.parse(new File(getServletContext().getRealPath("/cd_catalog.xml")));
			//la méthode parse manipule soit un File, soit un InputStream, soit une chaine (contenu du fichier)	
			//à ce moment le fichier est ouvert et analyser (arbre DOM) stocké dans doc
			out.print("Fichier analysé");
			
			NodeList liste = doc.getChildNodes();
			for (int i=0; i<liste.getLength();i++){
				n= liste.item(i);
				out.print("<br> " + n.getNodeName()+" "+ n.getNodeValue()+"<br>");
				
				if(n.getNodeType()== Node.ELEMENT_NODE){ //élimine noeud de type commentaire et ne garde que les élements
				//autre méthode if(n.getNodeType() != Node.COMMENT_NODE)
				//Parcours et affichage des titres de CD
				NodeList lesCd = n.getChildNodes();
					for (int j =0; j<lesCd.getLength();j++){
						if(lesCd.item(j).getNodeType()== Node.ELEMENT_NODE){ //élimine les #text (saut de lignes entre éléments)
							Node leCd = lesCd.item(j);
							//le frère du premier fils est le noeud de l'élément Title
							Node leTitre = leCd.getFirstChild().getNextSibling();
							String titre = leTitre.getFirstChild().getNodeValue();
							//récupération des noeuds
							//out.print("CD : " + leCd.getNodeName()+" "+ leTitre.getNodeName()+"<br>");
							out.print("CD : " + titre + "<br>");
						}
					}	
				}
			}
			//les élements n'ont qu'un nom mais pas de valeur
			//les commentaires c'est l'inverse, n'ont pas de noms, mais une valeur
			
			
			//METHODE recherche par nom
			NodeList lesTitres = doc.getElementsByTagName("TITLE");
			for (int i=0; i< lesTitres.getLength();i++){
				out.print("CD : "+lesTitres.item(i).getFirstChild().getNodeValue()+"<br>");
			}
				} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
