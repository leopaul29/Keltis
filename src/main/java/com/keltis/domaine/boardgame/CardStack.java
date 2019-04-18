package com.keltis.domaine.boardgame;

import java.util.Stack;

public abstract class CardStack extends Stack<Card> {

	/**
	 * Attributes
	 */
	protected Color color;

	/**
	 * Constructor
	 * 
	 * @param c
	 */
	public CardStack(Color c) {
		this.color = c;
	}

	/**
	 * Check the card of the top of the stack
	 * @return
	 */
	public Card checkTopCard() {
		return this.peek();
	}
	
	/**
	 * Check if can add the card ont the top of the stack
	 * @param c
	 * @return
	 */
	public abstract boolean canAddCard(Card c);

	/**
	 * Add card on the top of the stack
	 * 
	 * @param c
	 */
	public abstract boolean addCard(Card c);

	/**
	 * Getters
	 */
	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "CardStack [color=" + color + ", size()=" + size() + ", toString()=" + super.toString() + "]\n";
	}

}
