package com.cynical.android.euchre.server.socket.network;

import java.net.Socket;

public class ConnectedUser {
	
	private EuchreSocketAdapter sockAdapter;
	
	public ConnectedUser(Socket s) {
		this.sockAdapter = new EuchreSocketAdapter(s);
	}

}
