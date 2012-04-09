package com.cynical.euchre.server.netty.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.cynical.euchre.netty.commands.EuchreCommand;
import com.cynical.euchre.netty.commands.model.CommandPayloadDecodedModel;
import com.cynical.euchre.netty.commands.server.login.LoginCommandModel;

public class ServerHandler extends SimpleChannelHandler {
	
	Logger log = Logger.getLogger(getClass());

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
				LoginCommandModel loginModel = model.getPayload(LoginCommandModel.class);
				log.info(loginModel.getUsername());
				break;
			}
		}
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelOpen(ctx, e);
		
		log.info("User connected: " + e.getChannel().getRemoteAddress());
	}

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		
		log.info("User disconnected: " + e.getChannel().getRemoteAddress());
	}
	
	

}
