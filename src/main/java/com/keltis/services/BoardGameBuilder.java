package com.keltis.services;

import java.util.Collections;

import com.keltis.domaine.boardgame.BoardGame;
import com.keltis.domaine.boardgame.Color;

public class BoardGameBuilder {


	private static BoardGameBuilder instance = new BoardGameBuilder();

	private BoardGameBuilder () {}

	public static BoardGameBuilder getInstance() { return instance; }
	
	private CardGameBuilder cardGameBuilder = CardGameBuilder.getInstance();

	// init BoardGame discards, paths and wishstones
	private BoardGame bg = BoardGame.getInstance();
	
	public void build() {
		KeltisLogger.debug("BoardGameBuilder build");

		// create cardsand add it to the pico, suffle the pico and remove the first 30 cards
		createCardGame();
		shufflePico();
		removeFirstCard();
		
		// create wishstones
		createWishStones();
	}
	
	private void createCardGame() {
		cardGameBuilder.createCardGameColor(Color.RED);
		cardGameBuilder.createCardGameColor(Color.BLUE);
		cardGameBuilder.createCardGameColor(Color.YELLOW);
		cardGameBuilder.createCardGameColor(Color.GREEN);
		cardGameBuilder.createCardGameColor(Color.VIOLLET);
		cardGameBuilder.createGrayCards();
	}
	
	private void createWishStones() {
		cardGameBuilder.createWishStones();
	}
	
	private void shufflePico() {
		KeltisLogger.debug("BoardGameBuilder shufflePico");
		Collections.shuffle(this.bg.getPico());
	}
	
	/**
	 * Remove the first 30 cards of the pico
	 */
	private void removeFirstCard() {
		KeltisLogger.debug("BoardGameBuilder removeFirstCard");
		for(int i =0; i<30; i++) {
			this.bg.getPico().remove(i);
		}
	}
}
