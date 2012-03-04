package com.cynical.android.euchre.server.game.lobby;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.cynical.android.euchre.server.socket.network.ConnectedUser;

public class Lobby extends Thread {
	
	Set<ConnectedUser> users;
	//TODO:	A Set of games 

	@Override
	public void run() {
		users = Collections.synchronizedSet(new HashSet<ConnectedUser>());
		
	}	
	
	public synchronized boolean addUser(ConnectedUser user) {
		users.add(user);
		if(users.contains(user)) {
			return true;
		}
		
		return false;
	}

}
