package com.keltis.services;

import com.keltis.domaine.boardgame.BoardGame;

public class KeltisLogger {
	/**
	 * Logger level:
	 * <ul>
	 * <li>infoForced</li>
	 * <li>0: nothing</li>
	 * <li>1: info</li>
	 * <li>2: infoAI</li>
	 * <li>3: debug</li>
	 * <li>4: error</li>
	 * </ul>
	 */
	private static int level;

	private static int nbInfo;
	private static int nbInfoAI;
	private static int nbDebug;
	private static int nbError;

	public static void setLevel(int lvl) {
		level = lvl;
	}

	public static void infoForced(String message) {
		System.out.println("[INFO_FORCED] " + message);
	}

	public static void info(String message) {
		if (level >= 1) {
			nbInfo++;
			System.out.println("[INFO] " + message);
		}
	}

	public static void infoAI(String message) {
		if (level >= 2) {
			nbInfoAI++;
			System.out.println("[INFO_AI] " + message);
		}
	}

	public static void debug(String message) {
		if (level >= 3) {
			nbDebug++;
			System.out.println("[DEBUG] " + message);
		}
	}

	public static void error(String message) {
		if (level >= 4) {
			nbError++;
			System.err.println("[ERROR] " + message);
		}
	}

	public static void boardGameStatus(int turn) {
		info("Player1 paths\n" + BoardGame.getInstance().getPathPlayer1().toString());
		info("Player2 paths\n" + BoardGame.getInstance().getPathPlayer2().toString());
		info("Discard\n" + BoardGame.getInstance().getDiscards().toString());
		info("WishStones\n" + BoardGame.getInstance().getWishStones().toString());
	}

	public static void logStatResult() {
		StringBuilder s = new StringBuilder("KeltisLogger lvl("+level+"): ");

		if(level>=1) s.append("[INFO:"+nbInfo+"]");
		if(level>=2) s.append("[INFO_AI:"+nbInfoAI+"]");
		if(level>=3) s.append("[DEBUG:"+nbDebug+"]");
		if(level>=4) s.append("[ERROR:"+nbError+"]");
		
		System.out.println(s.toString());
	}
}
