package com.cynical.android.euchre.server.game;

import org.jboss.netty.channel.Channel;

public class ServerContext {
	
	private static Lobby lobby;
	private final static ServerContext instance = new ServerContext();
	
	private ServerContext() {
		lobby = new Lobby();
	}
	
	public synchronized ServerContext getInstance() {
		return instance;
	}
	
	public synchronized static void addUser(Channel channel) {
		lobby.addUser("GetUserID", channel);
	}
	
	public synchronized static void disconnectUser(Channel channel) {
		lobby.disconnectUser(channel);
	}

}
