package com.cynical.android.euchre.server.game;

import com.cynical.android.euchre.server.game.lobby.Lobby;

public class Context {
	
	Lobby lobby;
	
	public Context() {
		lobby = new Lobby();
	}

	public Lobby getLobby() {
		return lobby;
	}

}
