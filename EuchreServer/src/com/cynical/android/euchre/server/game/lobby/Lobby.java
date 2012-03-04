package com.cynical.android.euchre.server.game.lobby;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cynical.android.euchre.server.socket.network.ConnectedUser;

public class Lobby extends Thread {
	
	Logger log = Logger.getLogger(Lobby.class);
	
	Set<ConnectedUser> users;
	//TODO:	A Set of games 
	
	public Lobby() {
		users = Collections.synchronizedSet(new HashSet<ConnectedUser>());
	}

	@Override
	public void run() {
		
		
	}	
	
	public synchronized boolean addUser(ConnectedUser user) {
		users.add(user);
		if(users.contains(user)) {
			log.debug("User connected from " + user.getUserIpAddress());
			return true;
		}
		
		return false;
	}

}
