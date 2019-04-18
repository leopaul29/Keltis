package com.keltis.controllers.AIs;

import com.keltis.domaine.boardgame.Card;
import com.keltis.services.KeltisLogger;

/**
 * AI level 0: will discard all its card
 * 
 * @author LP
 *
 */
public class AIPlayer3Controller extends AIPlayerController {

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

		Card c = null;

		for (int i = 0; i < this.player.size(); i++) {

			c = this.player.lookCardAt(i);
			KeltisLogger.infoAI("I look at the card in my hand " + c.toString());

			if (canPlayCardOnPaths(c))
				break;
		}

		c = this.player.takeCardFromHand(c);
		KeltisLogger.infoAI("I take " + c.toString() + " from my hand");

		boolean action = this.playCardOnPaths(c);
		KeltisLogger.infoAI("playCardOnPaths " + c.toString() + " action on path is " + action);

		if (!action) {
			action = this.discardCard(c);
			KeltisLogger.infoAI("discardCard " + c.toString() + " action is " + action);
		}
	}

}
