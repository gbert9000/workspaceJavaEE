package com.TestPanels.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class TestPanels implements EntryPoint, ClickHandler {
		DockLayoutPanel panelBase;
		DeckLayoutPanel content;
		Grid panelMenu;
		Button b1, b2;

	public void onModuleLoad() {
		panelBase = new DockLayoutPanel(Unit.EM);
		content = new DeckLayoutPanel();
		panelMenu = new Grid(2,1);
		b1 = new Button("Section 1", this);
		b2 = new Button("Section 2", this);
		panelMenu.setWidget(0, 0, b1);
		panelMenu.setWidget(1, 0, b2);
		content.add(new HTML("<h2> Section 1</h2><p>Contenu...blah blah Ipsam ...</p>"));
		content.add(new HTML("<h2> Section 2</h2><p>La suite Cumque ...</p>"));
		content.showWidget(0);
		panelBase.addNorth(new HTML("<h1>Une nouvelle application</h1>"), 10);
		panelBase.addWest(panelMenu, 10);
		panelBase.add(content);
		RootLayoutPanel.get().add(panelBase);
	}
	
	public void onClick(ClickEvent evt) {
		if (evt.getSource() == b1)
		content.showWidget(0);
		else content.showWidget(1);
	}


}