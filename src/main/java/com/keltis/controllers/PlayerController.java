package com.keltis.controllers;

import java.util.HashMap;

import com.keltis.domaine.boardgame.BoardGame;
import com.keltis.domaine.boardgame.Card;
import com.keltis.domaine.boardgame.CardStack;
import com.keltis.domaine.boardgame.Color;
import com.keltis.domaine.boardgame.Discard;
import com.keltis.domaine.boardgame.Player;
import com.keltis.services.KeltisLogger;

public abstract class PlayerController {

	/**
	 * Attributes
	 */
	protected Player player;
	protected HashMap<Color, CardStack> playerPaths;
	protected HashMap<Color, CardStack> opponentPaths;
	protected HashMap<Color, Discard> discards = BoardGame.getInstance().getDiscards();
	private BoardGame bg = BoardGame.getInstance();

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public PlayerController() {
		this.player = new Player(getClass().getSimpleName());
	}

	public PlayerController(String name) {
		this.player = new Player(name);
	}

	/**
	 * Init player and oppenent path for the player
	 * 
	 * @param playerPaths
	 * @param opponentPaths
	 */
	public void initPlayer(HashMap<Color, CardStack> playerPaths, HashMap<Color, CardStack> opponentPaths) {
		this.playerPaths = playerPaths;
		this.opponentPaths = opponentPaths;
	}

	/**
	 * Regular turn play
	 * 
	 * @param turn
	 */
	public void play(int turn) {
		KeltisLogger.info("Play: " + this.player.toString());
	}

	/**
	 * Last turn play
	 * 
	 * @param turn
	 */
	public void playLastTurn(int turn) {
		KeltisLogger.info("playLastTurn: " + this.player.toString());
	}

	/**
	 * You play 2 way: put a card on a path. The card will stay there until the end
	 * OR put in on the discard with the same color of the card. Then the card can
	 * be took later by any player
	 */
	/**
	 * Check if the card can be put on a any path
	 * 
	 * @param c
	 * @return
	 */
	public boolean canPlayCardOnPaths(Card c) {
		boolean action = canPlayCardOnPathColor(c, this.playerPaths.get(c.getColor()));

		KeltisLogger.debug("PlayerControler canPlayCardOnPaths: " + action);
		return action;
	}

	/**
	 * Check if the card can be put on a specific path
	 * 
	 * @param c
	 * @param cardStack
	 * @return
	 */
	public boolean canPlayCardOnPathColor(Card c, CardStack cardStack) {
		if (cardStack == null) {
			KeltisLogger.error("PlayerControler playCardOnPathColor: cardStack is null");
			return false;
		}

		boolean action = cardStack.canAddCard(c);

		KeltisLogger.debug("PlayerControler canPlayCardOnPathColor: " + action + " " + c.toString() + " on "
				+ cardStack.getClass().getSimpleName() + ":" + cardStack.getColor());

		return action;
	}

	/**
	 * Put a card on a path can be done with ASCENDING order or DESCENDING order.
	 * Every path can be ASCENDING order or DESCENDING order but the order cannot
	 * change during the game. You can put two card with the same value on a path.
	 * The two series are validated series:
	 * <ul>
	 * <li>055567910</li>
	 * <li>774431</li>
	 * </ul>
	 */
	/**
	 * Play a card on any path
	 * @param c
	 * @return
	 */
	public boolean playCardOnPaths(Card c) {
		boolean action = playCardOnPathColor(c, this.playerPaths.get(c.getColor()));

		KeltisLogger.debug("PlayerControler playCardOnPaths: " + action);
		return action;
	}

	/**
	 * Play a card on a specific path
	 * @param c
	 * @param cardStack
	 * @return
	 */
	public boolean playCardOnPathColor(Card c, CardStack cardStack) {
		if (cardStack == null) {
			KeltisLogger.error("PlayerControler playCardOnPathColor: cardStack is null");
			return false;
		}

		boolean action = cardStack.addCard(c);

		KeltisLogger.debug("PlayerControler playCardOnPathColor: " + c.toString() + " on "
				+ cardStack.getClass().getSimpleName() + "[" + cardStack.getColor() + "] is " + action);

		return action;
	}

	/**
	 * Si vous ne souhaitez pas poser une carte sur un chemin, vous pouvez la
	 * défausser.</br>
	 * Il y a une pile de défausse par chemin/couleur.
	 * 
	 * @return
	 */
	public boolean discardCard(Card c) {
		if (c == null) {
			KeltisLogger.error("PlayerControler discardCard: card is null");
			return false;
		}

		KeltisLogger.debug("PlayerControler discardCard: " + c.toString() + " on discard " + c.getColor());

		return discards.get(c.getColor()).addCard(c);
	}

	/**
	 * Une fois que vous avez joué une carte, vous devez en prendre une autre :
	 * <ul>
	 * <li>de la pioche principale</li>
	 * <li>OU d'une des piles de défausse</li>
	 * </ul>
	 * Vous ne pouvez pas prendre une carte que vous venez de défausser !
	 */
	public boolean pickPicoCard() {
		if (this.player.size() >= 8) {
			KeltisLogger.error("PlayerControler pickPicoCard: player hand is full, player cannot pick");
			return false;
		}

		if (bg.getPico().size() == 0) {
			KeltisLogger.error("PlayerControler pickPicoCard: pico is empty, player cannot pick");
			return false;
		}

		Card c = bg.getPico().remove(0);

		if (c == null) {
			KeltisLogger.error("PlayerControler pickPicoCard: first card in pico is null, player cannot pick");
			return false;
		}

		KeltisLogger.debug(
				"PlayerControler pickPicoCard: " + this.player.getName() + " picked the card " + c + " in the pico");
		return this.player.addCardToHand(c);
	}

	public Card checkDiscardCardColor(Color c) {
		if (c == null || c == Color.WISH) {
			KeltisLogger.error("PlayerControler checkDiscardCardColor: color is " + c);
			return null;
		}

		KeltisLogger.debug("PlayerControler checkDiscardCardColor: " + this.player.getName() + " picked the card " + c
				+ " in the discard " + this.discards.get(c));
		return this.discards.get(c).checkTopCard();
	}

	public Card pickDiscardCardColor(Color c) {
		if (c == null || c == Color.WISH) {
			KeltisLogger.error("PlayerControler pickDiscardCardColor: color is " + c);
			return null;
		}

		KeltisLogger.debug("PlayerControler pickPicoCard: " + this.player.getName() + " picked the card " + c
				+ " in the discard " + this.discards.get(c));
		return this.discards.get(c).pickCard();
	}

	/**
	 * Action spéciale : prendre une pierre
	 * <ul>
	 * <li>Vous pouvez défausser deux cartes pour prendre une pierre. Ces deux
	 * cartes doivent être de même valeur.</li>
	 * <li>Il y a une pierre pour chaque valeur de 1 à 9. Et chacune ne peut être
	 * prise qu'une seule fois.</li>
	 * </ul>
	 * Après avoir pris une pierre, vous devez prendre deux cartes au lieu d'une.
	 */
	public void prendrePierre(Card c1, Card c2) {

		// check if pierre available before
		// !!!

		// check meme valeur
		if (c1.compareTo(c2) != 0)
			try {
				throw new Exception("Les cartes ne sont pas de même valeur");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

		discardCard(c1);
		discardCard(c2);

//		Value vp = c1.getValue();		
//		bg.prendrePierre(vp);

//		piocherCarte();
//		piocherCarte();
	}

}
