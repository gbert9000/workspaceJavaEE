package com.server;

import com.client.ProverbesServ;
import com.client.Proverbe;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
/**
* The serverside
implementation of the RPC service.
*/
@SuppressWarnings("serial")
public class ProverbesServImpl extends RemoteServiceServlet implements ProverbesServ {
	public Proverbe getProverbe() {
		return Proverbe.getNextProverbe();
	}
}