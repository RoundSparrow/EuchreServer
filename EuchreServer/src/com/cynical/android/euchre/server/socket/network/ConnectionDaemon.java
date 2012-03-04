package com.cynical.android.euchre.server.socket.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.cynical.android.euchre.server.game.Context;

public class ConnectionDaemon extends Thread {
	
	private static final int SOCKET_PORT = 12345;
	
	Logger log = Logger.getLogger(ConnectionDaemon.class);
	
	ServerSocket sock;
	
	Context context;
	
	public ConnectionDaemon(Context context) {
		this.context = context;
	}
	
	public void run() {
		try {
			log.info("Connection daemon started!");
			log.debug("Creating server socket listener on port " + SOCKET_PORT);
			sock = new ServerSocket(SOCKET_PORT, 10);
			log.debug("Socket listener created!");
		} catch (IOException e) {
			log.error("Unable to create socket listener...", e);
			return;
		}
		
		while(true) {
			try {
				Socket s = sock.accept();
				ConnectedUser user = new ConnectedUser(s);
				context.getLobby().addUser(user);
			} catch (IOException e) {
				log.error("Error when waiting for connection...", e);
			}
		}
	}

}
