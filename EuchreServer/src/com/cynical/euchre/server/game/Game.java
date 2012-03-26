package com.cynical.euchre.server.game;

import java.util.List;

import com.cynical.euchre.domain.CardDeck;
import com.cynical.euchre.player.Player;
import com.cynical.euchre.server.game.rules.RulesEngine;

public class Game extends Thread {
	
	CardDeck deck;
	RulesEngine rules;
	

	public Game(RulesEngine rules, List<Player> players) {
		this.deck = new CardDeck();
		this.rules = rules;
	}
	
	public void run() {
		
	}

}
