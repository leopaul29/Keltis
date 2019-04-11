package com.main.keltis;

import com.main.controlers.GameControler;
import com.main.controlers.PlayerControler;
import com.main.services.BoardGameBuilder;
import com.main.services.KeltisLogger;

public class KeltisGame {

	private PlayerControler pc1;
	private PlayerControler pc2;
	private GameControler gc;

	public KeltisGame(PlayerControler pc1, PlayerControler pc2) {
		this.pc1 = pc1;
		this.pc2 = pc2;
	}

	public void start() {
		KeltisLogger.debug("KeltisGame started");
		
		// create cards and wishstones
		// setup pico and board
		BoardGameBuilder.getInstance().build();
		
		// start the game
		gc = new GameControler(pc1, pc2);
		gc.init();
		gc.start();
		
		KeltisLogger.logStatResult();
	}

}
