package presentation;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MaDate extends SimpleTagSupport {

	private String temoin="";
	private boolean h24=false;
	
	@Override
	public void doTag() throws IOException, JspException{

		//outil d'écriture fournit par le WebApp Contener
		JspWriter out = getJspContext().getOut();
		
		Date date = new Date();
		SimpleDateFormat formater;
		//out.print(date.toLocaleString());
		if(h24)
			formater = new SimpleDateFormat("HH:mm");
		else
			formater = new SimpleDateFormat("hh:mm");
		
		//SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
		temoin = temoin + " -";
		out.print(formater.format(date)+temoin);
		if(getJspBody()!=null){
			out.print("[");
			StringWriter w = new StringWriter();
			getJspBody().invoke(w);
			out.print(w.toString().toUpperCase());
			out.print("]");
		}
		
	}
	
	public void setH24(String valeur){
		if(valeur.equals("true"))
		h24 = true;
	}
	
	
}
