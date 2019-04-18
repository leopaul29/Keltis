package com.keltis.domaine.boardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CardTest {
	
	private Card c;
	private Card cNull;
	private Card cEnd;
	
	public CardTest() {
		cNull = new Card(null, null);	
		c = new Card(Color.RED, Value.ONE);	
		cEnd = new Card(Color.RED, Value.END);
	}
	
	@Test
	public void cardCreationTest() {
		assertNotNull(c);
		assertNotNull(cNull);
	}
	
	@Test
	public void cardCompareToEqualsValueTest() {
		Card c0 = new Card(Color.RED, Value.ZERO);
		Card c1 = new Card(Color.RED, Value.ONE);
		Card c2 = new Card(Color.RED, Value.TWO);
		assertNotEquals(c.compareTo(c0), 0);
		assertEquals(c.compareTo(c1), 0);
		assertNotEquals(c.compareTo(c2), 0);
	}
	
	@Test
	public void cardCompareToLowerValueTest() {
		Card c0 = new Card(Color.RED, Value.ZERO);
		Card c1 = new Card(Color.RED, Value.ONE);
		Card c2 = new Card(Color.RED, Value.TWO);
		assertEquals(c.compareTo(c0), 1);
		assertNotEquals(c.compareTo(c1), 1);
		assertNotEquals(c.compareTo(c2), 1);
	}
	
	@Test
	public void cardCompareToUpperValueTest() {
		Card c0 = new Card(Color.RED, Value.ZERO);
		Card c1 = new Card(Color.RED, Value.ONE);
		Card c2 = new Card(Color.RED, Value.TWO);
		assertNotEquals(c.compareTo(c0), -1);
		assertNotEquals(c.compareTo(c1), -1);
		assertEquals(c.compareTo(c2), -1);
	}
	
	@Test
	public void cardIsColorTest() {
		assertFalse(c.isColor(Color.BLUE));
		assertTrue(c.isColor(Color.RED));
		assertFalse(c.isColor(null));
	}
	
	@Test
	public void cardIsEndCardTest() {
		assertFalse(c.isEndCard());
		assertTrue(cEnd.isEndCard());
		assertFalse(cNull.isEndCard());
	}
	
	@Test
	public void cardEqualsTest() {
		assertFalse(c.equals(null));
		assertFalse(c.equals(cEnd));
		assertFalse(c.equals(cNull));
	}
	
}
