package com.cynical.android.euchre.server.game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;

public class Lobby {
	
	public static final String ALL_USERS = "allUsers";
	
	private Map<Integer, User> userMap;
	private ChannelGroup allUserChannels;
	
	public Lobby() {
		userMap = new ConcurrentHashMap<Integer, User>();
		allUserChannels = new DefaultChannelGroup(ALL_USERS);
	}
	
	public void addUser(String userId, Channel chan) {
		userMap.put(chan.getId(), new User(userId, chan));
		allUserChannels.add(chan);
	}
	
	public void disconnectUser(Channel chan) {
		Channel c = allUserChannels.find(chan.getId());
		ChannelFuture future = c.close();
		future.addListener(new ChannelFutureListener() {
			
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				if (future.isSuccess()) {
					userMap.remove(future.getChannel().getId());
				}
			}
		});
	}
	
}
