package com.keltis.services;

import com.keltis.domaine.boardgame.BoardGame;
import com.keltis.domaine.boardgame.Card;
import com.keltis.domaine.boardgame.Color;
import com.keltis.domaine.boardgame.Value;
import com.keltis.domaine.boardgame.WishStone;

public class CardGameBuilder {

	private static CardGameBuilder instance = new CardGameBuilder();
	private CardFactory cardFactory = CardFactory.getInstance();
	
	private CardGameBuilder () {}

	public static CardGameBuilder getInstance() { return instance; }

	/**
	 * ONE card of 0, 1, 2, 8, 9, 10 value
	 * TWO card of 3, 4, 5, 6, 7 value
	 * TWO card FINISHED
	 * for EACH COLOR
	 * @param c
	 */
	public void createCardGameColor(Color c) {
		// ONE card of 0, 1, 2, 8, 9, 10 value
		addCard(cardFactory.createCard(c, Value.ZERO));
		addCard(cardFactory.createCard(c, Value.ONE));
		addCard(cardFactory.createCard(c, Value.TWO));
		addCard(cardFactory.createCard(c, Value.HEIGHT));
		addCard(cardFactory.createCard(c, Value.NINE));
		addCard(cardFactory.createCard(c, Value.TEN));
		
		// TWO card of 3, 4, 5, 6, 7 value
		addCard(cardFactory.createCard(c, Value.THREE));
		addCard(cardFactory.createCard(c, Value.THREE));
		addCard(cardFactory.createCard(c, Value.FOUR));
		addCard(cardFactory.createCard(c, Value.FOUR));
		addCard(cardFactory.createCard(c, Value.FIVE));
		addCard(cardFactory.createCard(c, Value.FIVE));
		addCard(cardFactory.createCard(c, Value.SIX));
		addCard(cardFactory.createCard(c, Value.SIX));
		addCard(cardFactory.createCard(c, Value.SEVEN));
		addCard(cardFactory.createCard(c, Value.SEVEN));
		
		// TWO card FINISHED
		addCard(cardFactory.createCard(c, Value.END));
		addCard(cardFactory.createCard(c, Value.END));
	}
	
	/**
	 * ONE card for earch value
	 */
	public void createGrayCards() {
		addCard(cardFactory.createCard(Color.GRAY, Value.ZERO));
		addCard(cardFactory.createCard(Color.GRAY, Value.ONE));
		addCard(cardFactory.createCard(Color.GRAY, Value.TWO));
		addCard(cardFactory.createCard(Color.GRAY, Value.THREE));
		addCard(cardFactory.createCard(Color.GRAY, Value.FOUR));
		addCard(cardFactory.createCard(Color.GRAY, Value.FIVE));
		addCard(cardFactory.createCard(Color.GRAY, Value.SIX));
		addCard(cardFactory.createCard(Color.GRAY, Value.SEVEN));
		addCard(cardFactory.createCard(Color.GRAY, Value.HEIGHT));
		addCard(cardFactory.createCard(Color.GRAY, Value.NINE));
		addCard(cardFactory.createCard(Color.GRAY, Value.TEN));
	}

	/**
	 * Add card to the pico
	 * @param c
	 */
	private void addCard(Card c) {
		BoardGame.getInstance().getPico().add(c);
	}
	
	public void createWishStones() {
		createWishStone(Value.ONE);
		createWishStone(Value.TWO);
		createWishStone(Value.THREE);
		createWishStone(Value.FOUR);
		createWishStone(Value.FIVE);
		createWishStone(Value.SIX);
		createWishStone(Value.SEVEN);
		createWishStone(Value.HEIGHT);
		createWishStone(Value.NINE);
	}
	
	private WishStone createWishStone(Value v) {
		return new WishStone(v);
	}
}
