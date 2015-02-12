package com.client;

import com.client.Proverbe;

import com.google.gwt.user.client.rpc.AsyncCallback;
/**
* The async counterpart of <code>ProverbesServ</code>.
*/
public interface ProverbesServAsync {
	void getProverbe(AsyncCallback<Proverbe> callback);
}