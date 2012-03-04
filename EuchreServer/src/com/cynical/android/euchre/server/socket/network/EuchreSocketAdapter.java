package com.cynical.android.euchre.server.socket.network;

import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;

/**
 * Provides all network functions needed for a user. Uses GSON to serialize objects to JSON strings when sending data.
 * @author Adam Benjamin
 *
 */
public class EuchreSocketAdapter {
	
	private Gson gson;
	
	private Socket sock;	
	
	/**
	 * Creates a new EuchreSocketAdapter
	 * @param s The socket to use
	 */
	public EuchreSocketAdapter(Socket s) {
		this.sock = s;
		this.gson = new Gson();
	}
	
	public boolean isConnected() {
		return sock.isConnected();
	}
	
	public String getIpAddress() {
		return sock.getInetAddress().getHostAddress();
	}
	
	/**
	 * Closes the socket connection
	 * @throws IOException If an I/O error occurs when closing the socket
	 */
	public void closeConnection() throws IOException {
		sock.close();
	}

}
