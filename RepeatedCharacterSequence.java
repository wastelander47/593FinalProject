
package org.ahmadsoft.ropes.impl;

import java.util.Arrays;

public class RepeatedCharacterSequence implements CharSequence {
	
	private char character;
	private int repeat;

	public RepeatedCharacterSequence(char character, int repeat) {
		super();
		this.character = character;
		this.repeat = repeat;
	}

	@Override
	public char charAt(int index) {
		return getCharacter();
	}

	@Override
	public int length() {
		return repeat;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return new RepeatedCharacterSequence(getCharacter(), end - start);
	}
	
	@Override
	public String toString() {
		char[] result = new char[repeat];
		Arrays.fill(result, character);
		return new String(result);
	}

	/**
	 * Returns the character used to construct this sequence.
	 * @return the character used to construct this sequence.
	 */
	public char getCharacter() {
		return character;
	}

}
