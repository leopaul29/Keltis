package com.keltis.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.keltis.domaine.boardgame.BoardGame;

public class BoardGameTest {
	
	@Test
	public void picoSizeAfterBuildTest() throws Exception {
		KeltisLogger.setLevel(3);
		
		BoardGameBuilder bgb = BoardGameBuilder.getInstance();
		bgb.build();
		
		assertTrue(BoardGame.getInstance().getPico().size()==71);
	}
}
