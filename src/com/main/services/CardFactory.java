package com.main.services;

import com.main.boardgame.Card;
import com.main.boardgame.Color;
import com.main.boardgame.Value;

public class CardFactory {

	private static CardFactory instance = new CardFactory();

	private CardFactory () {}

	public static CardFactory getInstance() { return instance; }

	public Card createCard(Color c, Value v) {
		return new Card(c, v);
	}
}
