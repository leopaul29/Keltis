package com.keltis.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.keltis.domaine.boardgame.BoardGame;
import com.keltis.domaine.boardgame.CardStack;
import com.keltis.domaine.boardgame.Color;
import com.keltis.domaine.boardgame.Value;

public class UtilsCounter {

	public static int getPlayerScore(HashMap<Color, CardStack> playerPaths) {
		int score = 0;

		// cela servira a parcourir la hashmap
		Set<Color> listKey = playerPaths.keySet();
		Iterator<Color> iterateur = listKey.iterator();

		// parcours de la hashmap tant qu'il y a une cle
		while (iterateur.hasNext()) {
			// recuperation de la cle
			Object key = iterateur.next();

			// recuperer la taille du chemins
			int taille = playerPaths.get(key).size();

			// si c'est un chemin
			if (key != Color.GRAY && key != Color.WISH) {
				// different cas selon les tailles
				switch (taille) {
				// pour que a ne prend pas 0 dans le default
				case 0:
					score += 0;
					break;

				case 1:
					score -= 4;
					break;

				case 2:
					score -= 3;
					break;

				case 3:
					score -= 2;
					break;

				case 4:
					score += 1;
					break;

				case 5:
					score += 2;
					break;

				case 6:
					score += 3;
					break;

				case 7:
					score += 6;
					break;

				case 8:
					score += 7;
					break;

				// des que c'est superieur ou egal a 9 cartes
				default:
					score += 10;
					break;
				}
			}
			// s'il s'agit du stock de perle
			else if (key == Color.WISH) {
				switch (taille) {
				case 0:
					score -= 4;
					break;

				case 1:
					score -= 1;
					break;

				case 2:
					score += 0;
					break;

				case 3:
					score += 4;
					break;

				case 4:
					score += 6;
					break;

				// 5 ou superieur a 5
				default:
					score += 10;
					break;
				}
			}

			// s'il s'agit du stock de pierre grise
			else {
				if (taille > 0) {
					score += taille;
				}
			}
		}

		return score;
	}

	public static int getNbPathFinished() {
		int nbPathFinised = 0;

		HashMap<Color, CardStack> pathPlayer1 = BoardGame.getInstance().getPathPlayer1();
		HashMap<Color, CardStack> pathPlayer2 = BoardGame.getInstance().getPathPlayer2();

		// cela servira a parcourir la hashmap de chemin du joueur 1
		Set<?> listKey = pathPlayer1.keySet();
		Iterator<?> iterateur = listKey.iterator();
//
//				//parcours de la hashmap tant qu'il y a une clé
		while (iterateur.hasNext()) {
			// recuperation de la clé
			Object key = iterateur.next();
			// si c'est un chemin
			if (key != Color.GRAY && key != Color.WISH) {
				// recuper la taille du chemin
				int tailleChemin = pathPlayer1.get(key).size();
				// verifier que le chemin n'est pas vide
				if (pathPlayer1.get(key).size() > 0) {
					// si la derniere carte du chemin est une carte fin
					if (pathPlayer1.get(key).get(tailleChemin - 1).getValue() == Value.END) {
						nbPathFinised++;
					}
				}
			}
		}

		// cela servira a parcourir la hashmap de chemin du joueur 2
		listKey = pathPlayer2.keySet();
		iterateur = listKey.iterator();

		// parcours de la hashmap tant qu'il y a une clé
		while (iterateur.hasNext()) {
			// recuperation de la clé
			Object key = iterateur.next();
			// si c'est un chemin
			if (key != Color.GRAY && key != Color.WISH) {
				// recuper la taille du chemin
				int tailleChemin = pathPlayer2.get(key).size();
				// si la taille du chemin > 0
				if (pathPlayer2.get(key).size() > 0) {
					// si la derniere carte du chemin est une carte fin
					if (pathPlayer2.get(key).get(tailleChemin - 1).getValue() == Value.END) {
						nbPathFinised++;
					}
				}
			}
		}
		KeltisLogger.info(nbPathFinised + " paths are finished");

		return nbPathFinised;
	}
}
