package com.main.boardgame;

import java.util.ArrayList;
import java.util.Collections;

import com.main.services.KeltisLogger;

public class Player extends ArrayList<Card> {

	/**
	 * Attributes
	 */
	private String name;

	/**
	 * Constructor
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * Add card in my hand, then sort my hand
	 * @param c
	 * @return
	 */
	public boolean addCardToHand(Card c) {
		if (c == null) {
			KeltisLogger.error("Player addCardToHand: card is null");
			return false;
		}

		boolean res = this.add(c);

		Collections.sort(this);

		return res;
	}

	/**
	 * Look the card at index
	 * @param indexCard
	 * @return
	 */
	public Card lookCardAt(int indexCard) {
		if (indexCard < 0 || indexCard >= size()) {
			KeltisLogger.error("Player getCardIndex: index card " + indexCard + " does not exist");
			return null;
		}

		return this.get(indexCard);
	}

	/**
	 * Get the index of a card
	 * @param c
	 * @return
	 */
	private int getCardIndex(Card c) {
		if (c == null) {
			KeltisLogger.error("Player getCardIndex: card is null");
			return -1;
		}

		int index = -1;
		// Search card in hand
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(c)) {
				index = i;
				break;
			}
		}

		return index;
	}

	/**
	 * Take out a card of my hand, don't loose it
	 * @param c
	 * @return
	 */
	public Card takeCardFromHand(Card c) {
		int indexCard = this.getCardIndex(c);

		if (indexCard == -1) {
			KeltisLogger.error("Player takeCardFromHand: card " + c.toString() + " does not exist");
			return null;
		}

		// take Card from hand
		return this.remove(indexCard);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", size()=" + size() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * Getters
	 */
	public String getName() {
		return name;
	}

}
