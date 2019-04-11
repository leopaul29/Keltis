package com.main.keltis;

import com.main.controlers.AIs.AIPlayer1Controler;
import com.main.controlers.AIs.AIPlayer2Controler;
import com.main.controlers.AIs.AIPlayer3Controler;
import com.main.services.KeltisLogger;

public class KeltisLauncher {

	public static void main(String[] args) {
		firstAIagainstItself();
	}
	
	public static void firstAIagainstItself() {
		KeltisLogger.setLevel(4);
		
		AIPlayer1Controler pc1 = new AIPlayer1Controler();
		AIPlayer2Controler pc2 = new AIPlayer2Controler();
		AIPlayer3Controler pc3 = new AIPlayer3Controler();
		
		KeltisGame kg = new KeltisGame(pc1, pc3);
		kg.start();
	}
}
