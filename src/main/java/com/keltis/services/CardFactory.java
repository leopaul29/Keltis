package com.keltis.services;

import com.keltis.domaine.boardgame.Card;
import com.keltis.domaine.boardgame.Color;
import com.keltis.domaine.boardgame.Value;

public class CardFactory {

	private static CardFactory instance = new CardFactory();

	private CardFactory () {}

	public static CardFactory getInstance() { return instance; }

	public Card createCard(Color c, Value v) {
		return new Card(c, v);
	}
}
