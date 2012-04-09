package com.cynical.euchre.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.cynical.euchre.netty.decoders.EuchreCommandDecoder;
import com.cynical.euchre.netty.encoders.EuchreCommandEncoder;
import com.cynical.euchre.server.netty.handler.ServerHandler;

public class Init {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*ConnectionDaemon daemon = new ConnectionDaemon(new Context());
		Logger log = Logger.getLogger(Init.class);
		log.info("Starting connection daemon...");
		daemon.start();*/
		
		Logger log = Logger.getLogger(Init.class);
		
		ChannelFactory factory = new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());
		
		ServerBootstrap bootstrap = new ServerBootstrap(factory);
		
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {			
			
			public ChannelPipeline getPipeline() throws Exception {		
				
				ChannelPipeline pipeline = Channels.pipeline();
				
				// Decoders
		        pipeline.addLast("CommandDecoder", new EuchreCommandDecoder());

		        // Encoders
		        pipeline.addLast("CommandEncoder", new EuchreCommandEncoder());
		        
		        pipeline.addLast("ServerHandler", new ServerHandler());
		        
				return pipeline;
			}
		});
		
		bootstrap.setOption("child.tcpNoDelay", true);
		bootstrap.setOption("child.keepAlive", true);
		
		bootstrap.bind(new InetSocketAddress(12345));
		
		log.info("Server Started");

	}

}
