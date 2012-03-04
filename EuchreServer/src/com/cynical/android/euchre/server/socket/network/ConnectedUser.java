package com.cynical.android.euchre.server.socket.network;

import java.io.IOException;
import java.net.Socket;

public class ConnectedUser {
	
	private EuchreSocketAdapter sockAdapter;
	
	public ConnectedUser(Socket s) {
		this.sockAdapter = new EuchreSocketAdapter(s);
	}
	
	public boolean isConnected() {
		return sockAdapter.isConnected();
	}
	
	public boolean destroy() {
		try {
			sockAdapter.closeConnection();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
