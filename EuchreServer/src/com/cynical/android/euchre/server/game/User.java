package com.cynical.android.euchre.server.game;

import org.jboss.netty.channel.Channel;

public class User {
	
	private String userId;
	private int channelId;
	
	public User(String userId, Channel channel) {
		this.userId = userId;
		channelId = channel.getId();
	}

	public String getUserId() {
		return userId;
	}

	public int getChannelId() {
		return channelId;
	}
}
