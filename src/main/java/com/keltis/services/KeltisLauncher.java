package com.keltis.services;

import com.keltis.controllers.AIs.AIPlayer1Controller;
import com.keltis.controllers.AIs.AIPlayer2Controller;
import com.keltis.controllers.AIs.AIPlayer3Controller;

public class KeltisLauncher {

	public static void main(String[] args) {
		firstAIagainstItself();
	}
	
	public static void firstAIagainstItself() {
		KeltisLogger.setLevel(4);
		
		AIPlayer1Controller pc1 = new AIPlayer1Controller();
		AIPlayer2Controller pc2 = new AIPlayer2Controller();
		AIPlayer3Controller pc3 = new AIPlayer3Controller();
		
		KeltisGame kg = new KeltisGame(pc1, pc3);
		kg.start();
	}
}
