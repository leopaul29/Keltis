package com.keltis.domaine.boardgame;

import com.keltis.services.KeltisLogger;

public class Path extends CardStack {

	public enum Order {
		UNDEFINED, ASCENDING, DESCENDING, FINISHED1, FINISHED2;
	}

	/**
	 * Attributes
	 */
	private Order order;

	/**
	 * Constructor
	 * 
	 * @param color
	 */
	public Path(Color c) {
		super(c);
		this.order = Order.UNDEFINED;
	}

	/**
	 * Add card on the top of the stack can change the path order.
	 * 
	 * Si le chemin n'a pas d'ordre, on pose la carte. Si le chemin etait vide, pas
	 * de changement d'ordre. Si le chemin n'etait pas vide, on calcule le
	 * changement d'ordre
	 * 
	 * Si le chemin est d'ordre CROISSANT, on verifie si on peut poser la carte
	 * 
	 * Si le chemin est d'ordre DECROISSANT, on verifie si on peut poser la carte
	 * 
	 * Si la carte est GRISE(speciale) et de meme valeur que la carte du dessus du
	 * chemin
	 * 
	 * Si c'est une carte fin et chemin pas termine, on la pose Sinon on verifie
	 * l'ordre est TERMINE1, on la pose Sinon on ne pose pas la carte fin
	 * 
	 */
	@Override
	public boolean canAddCard(Card c) {
		if (c == null) {
			KeltisLogger.error("Path canAddCard: cannot add card null");
			return false;
		}
		KeltisLogger.debug("Path canAddCard: " + toString());

		int compareCarte = 0;
		if (size() != 0) {
			compareCarte = checkTopCard().compareTo(c);
		}

		// If GRAY CARD and same VALUE than top card
		if (size() != 0 && c.isColor(Color.GRAY) && compareCarte == 0) {
			KeltisLogger.debug("Path canAddCard: can add GRAY card");
			return true;
		}

		if (!c.getColor().equals(this.color)) {
			KeltisLogger.debug("Path canAddCard: cannot add card because color " + c.getColor()
					+ " is different from path color " + getColor());
			return false;
		}

		// If order is UNDEFINED
		if (isOrder(Order.UNDEFINED)) {
			KeltisLogger.debug("Path canAddCard: can add card to a path with order UNDEFINED");
			return true;
		}

		// If order is ASCENDING
		if (isOrder(Order.ASCENDING) && compareCarte <= 0) {
			KeltisLogger.debug("Path canAddCard: can add card to a path with order ASCENDING");
			return true;
		}

		// If order is DESCENDING
		if (isOrder(Order.DESCENDING) && compareCarte >= 0) {
			KeltisLogger.debug("Path canAddCard: can add card to a path with order DESCENDING");
			return true;
		}

		// If END card
		if (c.isEndCard()) {
			// If path not finished yet
			if (!isFinished()) {
				KeltisLogger.debug("Path canAddCard: can add card to a path not finished yet");
				return true;
			} else
			// If path already finished once
			if (isOrder(Order.FINISHED1)) {
				KeltisLogger.debug("Path canAddCard: can add card to a path with one card END");
				return true;
			}
			// If End card and Order is FINISHED2
			KeltisLogger.debug("Path canAddCard: cannot add card to a path with two card END");
			return false;
		}

		return false;
	}

	@Override
	public boolean addCard(Card c) {
		if (!canAddCard(c))
			return false;

		int compareCarte = 0;
		if (size() != 0) {
			compareCarte = checkTopCard().compareTo(c);
		}

		// If GRAY CARD and same VALUE than top card
		if (size() != 0 && c.isColor(Color.GRAY) && compareCarte == 0) {
			KeltisLogger.debug("Path addCard: put GRAY card");
			putCard(c);
			return true;
		}

		// If order is UNDEFINED
		if (isOrder(Order.UNDEFINED)) {
			KeltisLogger.debug("Path addCard: order is UNDEFINED");
			putCard(c);
			if (size() != 0 && compareCarte > 0) {
				changeOrder(Order.DESCENDING);
			} else if (size() != 0 && compareCarte < 0) {
				changeOrder(Order.ASCENDING);
			}
			return true;
		}

		// If order is ASCENDING
		if (isOrder(Order.ASCENDING) && compareCarte <= 0) {
			putCard(c);
			return true;
		}

		// If order is DESCENDING
		if (isOrder(Order.DESCENDING) && compareCarte >= 0) {
			putCard(c);
			return true;
		}

		// If END card
		if (c.isEndCard()) {
			// If path not finished yet
			if (!isFinished()) {
				putCard(c);
				changeOrder(Order.FINISHED1);
				return true;
			} else
			// If path already finished once
			if (isOrder(Order.FINISHED1)) {
				putCard(c);
				changeOrder(Order.FINISHED2);
				return true;
			}
			// If End card and Order is FINISHED2
			return false;
		}

		return false;
	}

	/**
	 * Put a card on the top of the stack
	 * 
	 * @param c
	 */
	private void putCard(Card c) {
		if (c == null) {
			KeltisLogger.error("Path putCard: card is null");
			return;
		}

		KeltisLogger.debug("Path putCard: put the card " + c.toString());
		this.push(c);
	}

	/**
	 * Change path order
	 * 
	 * @param o
	 */
	private void changeOrder(Order o) {
		if (o == null) {
			KeltisLogger.error("Path changeOrder: Order is null");
			return;
		}

		if (isOrder(Order.UNDEFINED)) {
			this.order = o;
			KeltisLogger.debug("Path changeOrder: order changing for " + o.toString());
		}
	}

	/**
	 * Getters
	 */
	public Order getOrder() {
		return order;
	}

	public boolean isOrder(Order o) {
		return this.order.equals(o);
	}

	public boolean isFinished() {
		return isOrder(Order.FINISHED1) || isOrder(Order.FINISHED2);
	}

	@Override
	public String toString() {
		return "Path [order=" + order + ", toString()=" + super.toString() + "]";
	}
}
