package com.keltis.domaine.boardgame;

import java.util.Comparator;

public enum Value {
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), HEIGHT(8), NINE(9), TEN(10), END(99);

	int value;

	Value(int v) {
		this.value = v;
	}
}

/**
 * Compare value
 * 
 * @author LP
 *
 */
class ValeurComparator implements Comparator<Value> {

	@Override
	public int compare(Value v1, Value v2) {
		return v1.value - v2.value;
	}

}
