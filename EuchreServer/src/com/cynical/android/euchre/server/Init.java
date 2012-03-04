package com.cynical.android.euchre.server;

import org.apache.log4j.Logger;

import com.cynical.android.euchre.server.game.Context;
import com.cynical.android.euchre.server.socket.network.ConnectionDaemon;

public class Init {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConnectionDaemon daemon = new ConnectionDaemon(new Context());
		Logger log = Logger.getLogger(Init.class);
		log.info("Starting connection daemon...");
		daemon.start();

	}

}
