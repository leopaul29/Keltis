package com.keltis.domaine.boardgame;

import com.keltis.services.KeltisLogger;

public class Card implements Comparable<Card> {

	/**
	 * Attributes
	 */
	private Color color;
	private Value value;

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param value
	 */
	public Card(Color c, Value v) {
		this.color = c;
		this.value = v;
	}

	/**
	 * Compare value of two cards
	 */
	@Override
	public int compareTo(Card c) {
		ValeurComparator vc = new ValeurComparator();
		return vc.compare(this.value, c.value);
	}

	public boolean isColor(Color c) {
		if (this.color == null) {
			KeltisLogger.error("Card isColor: color is null");
			return false;
		}

		if (c == null) {
			KeltisLogger.error("Card isColor: color to compare is null");
			return false;
		}

		return this.color.equals(c);
	}

	public boolean isEndCard() {
		if (this.value == null) {
			KeltisLogger.error("Card isEndCard: value is null");
			return false;
		}

		return this.value.equals(Value.END);
	}

	/**
	 * Getters
	 */
	public Color getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		Card other = (Card) o;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", value=" + value + "]";
	}

}
