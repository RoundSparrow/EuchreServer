package com.cynical.android.euchre.server.socket.network;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

public class ConnectionDaemon extends Thread {
	
	private static final int SOCKET_PORT = 12345;
	
	Logger log = Logger.getLogger(ConnectionDaemon.class);
	
	ServerSocket sock;
	
	public void run() {
		try {
			log.debug("Creating server socket listener on port " + SOCKET_PORT);
			sock = new ServerSocket(SOCKET_PORT, 10);
		} catch (IOException e) {
			log.error("Unable to create socket listener...", e);
			return;
		}
		
		/*while(true) {
			
		}*/
	}

}
