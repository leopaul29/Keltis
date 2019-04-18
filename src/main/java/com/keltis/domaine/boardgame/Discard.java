package com.keltis.domaine.boardgame;

import com.keltis.services.KeltisLogger;

public class Discard extends CardStack {

	/**
	 * Constructor
	 * 
	 * @param c
	 */
	public Discard(Color c) {
		super(c);
	}

	@Override
	public boolean canAddCard(Card c) {
		if (c == null) {
			KeltisLogger.error("Discard canAddCard: card is null");
			return false;
		}
		KeltisLogger.debug("Discard canAddCard: " + toString());

		if (!c.getColor().equals(this.color)) {
			KeltisLogger.error("Discard canAddCard: cannot add card because color " + c.getColor()
					+ " is different from discard color " + getColor());
			return false;
		}

		return true;
	}

	@Override
	public boolean addCard(Card c) {
		if (!canAddCard(c))
			return false;

		this.push(c);
		return true;
	}

	/**
	 * Remove and return the top card of the stack
	 * 
	 * @return
	 */
	public Card pickCard() {
		if (size() == 0) {
			KeltisLogger.error("Discard pickCard: discard is empty");
			return null;
		}

		return this.pop();
	}

	@Override
	public String toString() {
		return "Discard [toString()=" + super.toString() + "]";
	}

}
