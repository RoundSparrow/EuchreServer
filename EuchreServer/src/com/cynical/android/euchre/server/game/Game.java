package com.cynical.android.euchre.server.game;

import com.cynical.android.euchre.server.game.rules.RulesEngine;

public class Game extends Thread {
	
	RulesEngine rules;

	public Game(RulesEngine rules) {
		this.rules = rules;
	}
	
	public void run() {
		
	}

}
