package com.keltis.domaine.boardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.keltis.services.KeltisLogger;
import com.keltis.services.UtilsCounter;

public class BoardGame {

	private static BoardGame instance = new BoardGame();

	public static BoardGame getInstance() {
		return instance;
	}

	/**
	 * Attributes
	 */
	// Player's path
	private HashMap<Color, CardStack> pathPlayer1 = new HashMap<Color, CardStack>();
	private HashMap<Color, CardStack> pathPlayer2 = new HashMap<Color, CardStack>();

	// BoardGame discards
	private HashMap<Color, Discard> discards = new HashMap<Color, Discard>();

	// Board wishstones and pico
	private List<WishStone> wishStones;
	private List<Card> pico;

	// Player's score
	private int scorePlayer1;
	private int scorePlayer2;

	/**
	 * Constructor
	 */
	private BoardGame() {
		init();
	}

	public void init() {
		// BoardGame discards
		discards.put(Color.RED, new Discard(Color.RED));
		discards.put(Color.BLUE, new Discard(Color.BLUE));
		discards.put(Color.YELLOW, new Discard(Color.YELLOW));
		discards.put(Color.VIOLLET, new Discard(Color.VIOLLET));
		discards.put(Color.GREEN, new Discard(Color.GREEN));
		discards.put(Color.GRAY, new Discard(Color.GRAY));

		// Player1 paths, wishStones and graycards
		pathPlayer1.put(Color.RED, new Path(Color.RED));
		pathPlayer1.put(Color.BLUE, new Path(Color.BLUE));
		pathPlayer1.put(Color.YELLOW, new Path(Color.YELLOW));
		pathPlayer1.put(Color.VIOLLET, new Path(Color.VIOLLET));
		pathPlayer1.put(Color.GREEN, new Path(Color.GREEN));
		pathPlayer1.put(Color.GRAY, new Stack(Color.GRAY));
		pathPlayer1.put(Color.WISH, new Stack(Color.WISH));

		// Player2 paths, wishStones and graycards
		pathPlayer2.put(Color.RED, new Path(Color.RED));
		pathPlayer2.put(Color.BLUE, new Path(Color.BLUE));
		pathPlayer2.put(Color.YELLOW, new Path(Color.YELLOW));
		pathPlayer2.put(Color.VIOLLET, new Path(Color.VIOLLET));
		pathPlayer2.put(Color.GREEN, new Path(Color.GREEN));
		pathPlayer2.put(Color.GRAY, new Stack(Color.GRAY));
		pathPlayer2.put(Color.WISH, new Stack(Color.WISH));

		// Board wishstones and pico
		wishStones = new ArrayList<WishStone>();

		pico = new ArrayList<Card>();
	}

	public boolean isPicoEmpty() {
		KeltisLogger.info("Pico size is " + getPico().size());
		return getPico().size() == 0;
	}

	public void updateScore() {
		this.scorePlayer1 = UtilsCounter.getPlayerScore(pathPlayer1);
		this.scorePlayer2 = UtilsCounter.getPlayerScore(pathPlayer2);
	}

	/**
	 * Getters
	 */
	public HashMap<Color, CardStack> getPathPlayer1() {
		return pathPlayer1;
	}

	public HashMap<Color, CardStack> getPathPlayer2() {
		return pathPlayer2;
	}

	public HashMap<Color, Discard> getDiscards() {
		return discards;
	}

	public List<WishStone> getWishStones() {
		return wishStones;
	}

	public List<Card> getPico() {
		return pico;
	}

	public int getScorePlayer1() {
		updateScore();
		return scorePlayer1;
	}

	public int getScorePlayer2() {
		updateScore();
		return scorePlayer2;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		// ajouter au stringbuilder la carte a ecrire
		for (int i = 0; i < this.getPico().size() - 1; i++) {
			s.append(this.getPico().get(i).toString() + "\n");
		}
		// ajouter la derniere carte a ecrire
		s.append(this.getPico().get(this.getPico().size() - 1).toString());
		return s.toString();
	}

}
