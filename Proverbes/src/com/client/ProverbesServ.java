package com.client;

import com.client.Proverbe;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
* The clientside
stub for the RPC service.
*/
@RemoteServiceRelativePath("provServ")
public interface ProverbesServ extends RemoteService {
	Proverbe getProverbe();
}