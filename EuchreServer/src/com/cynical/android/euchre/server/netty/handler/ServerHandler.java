package com.cynical.android.euchre.server.netty.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.cynical.euchre.netty.commands.EuchreCommand;
import com.cynical.euchre.netty.commands.model.CommandPayloadDecodedModel;

public class ServerHandler extends SimpleChannelHandler {

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		Object obj = e.getMessage();
		if(obj instanceof CommandPayloadDecodedModel) {
			CommandPayloadDecodedModel model = (CommandPayloadDecodedModel) obj;
			EuchreCommand command = model.getCommand();
			switch(command) {
			case LOGIN:
				//Do Login
				break;
			}
		}
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelOpen(ctx, e);
	}
	
	

}
