package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class CamelCase {

	public static int findNumberOfWords(String str) {
		char[] letters = str.toCharArray();
		int noOfWords = 1;
		for (int i = 0; i < letters.length; i++) {
			if (Character.isUpperCase(letters[i])) {
				noOfWords++;
			}
			// what is uppercase is only one character???
		}

		return noOfWords;
	}

	public static boolean validateAlternatingSequence(char[] newSeq, int length) {
		for (int i = 0; i < length - 1; i++) {
			if (newSeq[i] == newSeq[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();

		System.out.println(findNumberOfWords(s));
	}
}