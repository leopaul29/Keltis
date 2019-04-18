package com.keltis.controllers.AIs;

import com.keltis.controllers.PlayerController;
import com.keltis.domaine.boardgame.Card;
import com.keltis.services.KeltisLogger;

/**
 * AI level 0: will discard all its card
 * 
 * @author LP
 *
 */
public class AIPlayer1Controller extends PlayerController {

	@Override
	public void play(int turn) {
		super.play(turn);

		basicAction();

		pickPicoCard();
	}

	@Override
	public void playLastTurn(int turn) {
		super.playLastTurn(turn);

		basicAction();
		basicAction();

		KeltisLogger.infoAI("playLastTurn end " + this.player.toString());
	}

	/**
	 * Will discard all its card
	 */
	private void basicAction() {
		Card c = this.player.lookCardAt(0);
		KeltisLogger.infoAI("The first card in my hand is " + c.toString());

		c = this.player.takeCardFromHand(c);
		KeltisLogger.infoAI("I take " + c.toString() + " from my hand");

		boolean action = this.discardCard(c);
		KeltisLogger.infoAI("discardCard " + c.toString() + " action is " + action);
	}

}
