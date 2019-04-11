package com.main.controlers.AIs;

import com.main.boardgame.Card;
import com.main.controlers.PlayerControler;
import com.main.services.KeltisLogger;

/**
 * AI level 0: will discard all its card
 * 
 * @author LP
 *
 */
public class AIPlayer1Controler extends PlayerControler {

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
