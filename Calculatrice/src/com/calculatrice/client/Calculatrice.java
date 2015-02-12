package com.calculatrice.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Calculatrice implements EntryPoint , ClickHandler {
	private TextBox operande1, operande2;
	private ListBox operation;
	private Button calculer;
	private HTML result;

	public void onModuleLoad() {
		operande1 = new TextBox();
		operande2 = new TextBox();
		operation = new ListBox();
		calculer = new Button("Calculer");
		operation.addItem("+");
		operation.addItem("-");
		operation.addItem("*");
		operation.addItem("/");
		calculer.addClickHandler(this);
		result = new HTML("Résultat");

		RootPanel.get("op1").add(operande1);
		RootPanel.get("op2").add(operande2);
		RootPanel.get("operation").add(operation);
		RootPanel.get("calculer").add(calculer);
		RootPanel.get("result").add(result);
		operande1.setFocus(true);
	}
	
	public void onClick(ClickEvent evt) {
		//RootPanel.get("resultat");
		Float resultat, oper1, oper2;
		String opName = operation.getSelectedItemText();
		try {
		oper1 = Float.parseFloat(operande1.getValue());
		oper2 = Float.parseFloat(operande2.getValue());
		if (opName.equals("+")) {
		resultat = oper1 + oper2;
		} else if (opName.equals("-"))
		{
		resultat = oper1 - oper2;
		} else if (opName.equals("*")) {
		resultat = oper1 * oper2;
		} else {
		resultat = oper1 / oper2;
		}
		result.setText("Résultat : " + resultat.toString());
		} catch (Exception e) {
		result.setHTML("<p style=\"color: red\">" + e.toString()+ "<p/>");
		}
		}
}