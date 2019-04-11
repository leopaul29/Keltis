package com.main.boardgame;

import com.main.services.KeltisLogger;

public class Stack extends CardStack {

	public Stack(Color c) {
		super(c);
	}

	@Override
	public boolean canAddCard(Card c) {
		if (c == null) {
			KeltisLogger.error("Stack addCard: card is null");
			return false;
		}
		KeltisLogger.debug("Stack addCard: " + toString());
		

		if (!c.getColor().equals(this.color)) {
			KeltisLogger
					.error("Stack addCard: card color " + c.getColor() + " is different from Stack color " + getColor());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean addCard(Card c) {
		if(!canAddCard(c)) return false;
		
		this.push(c);
		return true;
	}

	@Override
	public String toString() {
		return "Stack [toString()=" + super.toString() + "]";
	}

}
