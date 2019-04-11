package com.main.controlers;

import java.util.Collections;

import com.main.boardgame.BoardGame;
import com.main.services.KeltisLogger;
import com.main.services.UtilsCounter;

public class GameControler {

	private BoardGame bg = BoardGame.getInstance();

	/**
	 * Attributes
	 */
	private PlayerControler pc1;
	private PlayerControler pc2;
	private int turn;

	/**
	 * Constructor
	 * 
	 * @param p1
	 * @param p2
	 */
	public GameControler(PlayerControler pc1, PlayerControler pc2) {
		this.pc1 = pc1;
		this.pc2 = pc2;
		this.turn = 0;
	}

	public void init() {
		KeltisLogger.info("distributeCards");
		for (int i = 0; i < 8; i++) {
			pc1.pickPicoCard();
			pc2.pickPicoCard();
		}

		Collections.sort(pc1.player);
		Collections.sort(pc2.player);

		KeltisLogger.info("Player1 cards: " + pc1.player.toString());
		KeltisLogger.info("Player2 cards: " + pc2.player.toString());

		associatePlayerPaths();
	}

	private void associatePlayerPaths() {
		pc1.initPlayer(bg.getPathPlayer1(), bg.getPathPlayer2());
		pc2.initPlayer(bg.getPathPlayer2(), bg.getPathPlayer1());
	}

	public void start() {
		KeltisLogger.info("GameControler start");

		while (!isGameOver()) {
			turn++;
			KeltisLogger.info("\n\t--- Game Status turn " + turn + " ---");

			this.pc1.play(turn);
			bg.updateScore();

			if (isGameOver()) {
				break;
			}

			this.pc2.play(turn);
			bg.updateScore();

			displayPlayerScore();
		}

		KeltisLogger.info("\n\t--- Game Status playLastTurn ---");
		playLastTurn();

		gameOver();
	}

	private void playLastTurn() {
		KeltisLogger.info("\n\t--- Game Status playLastTurn player1 ---");
		this.pc1.playLastTurn(turn);

		KeltisLogger.info("\n\t--- Game Status playLastTurn player2 ---");
		this.pc2.playLastTurn(turn);
	}

	private void gameOver() {
		KeltisLogger.info("\n\t--- BoardGame Final Status ---");
		KeltisLogger.boardGameStatus(turn);
		displayPlayerScore();
	}

	private void displayPlayerScore() {
		KeltisLogger.info("\t--- Score ---");
		KeltisLogger.info("Score Player1: " + bg.getScorePlayer1());
		KeltisLogger.info("Score Player2: " + bg.getScorePlayer2());
	}

	private boolean isGameOver() {
		return bg.isPicoEmpty() || UtilsCounter.getNbPathFinished() >= 5;
	}

}
