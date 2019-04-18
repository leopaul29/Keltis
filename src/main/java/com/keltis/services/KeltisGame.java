package com.keltis.services;

import com.keltis.controllers.GameController;
import com.keltis.controllers.PlayerController;

public class KeltisGame {

	private PlayerController pc1;
	private PlayerController pc2;
	private GameController gc;

	public KeltisGame(PlayerController pc1, PlayerController pc2) {
		this.pc1 = pc1;
		this.pc2 = pc2;
	}

	public void start() {
		KeltisLogger.debug("KeltisGame started");
		
		// create cards and wishstones
		// setup pico and board
		BoardGameBuilder.getInstance().build();
		
		// start the game
		gc = new GameController(pc1, pc2);
		gc.init();
		gc.start();
		
		KeltisLogger.logStatResult();
	}

}
