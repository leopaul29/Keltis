package tests.core.game.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.main.boardgame.BoardGame;
import com.main.services.BoardGameBuilder;
import com.main.services.KeltisLogger;

public class BoardGameTest {
	
	@Test
	public void picoSizeAfterBuildTest() throws Exception {
		KeltisLogger.setLevel(3);
		
		BoardGameBuilder bgb = BoardGameBuilder.getInstance();
		bgb.build();
		
		assertTrue(BoardGame.getInstance().getPico().size()==71);
		
		KeltisLogger.debug(BoardGame.getInstance().toString());
	}
}
