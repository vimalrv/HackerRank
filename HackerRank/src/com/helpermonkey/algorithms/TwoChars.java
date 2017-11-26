package com.helpermonkey.algorithms;

import java.util.HashSet;
import java.util.Scanner;

public class TwoChars {

	public static int findLongestRepeatingString(int siz, String str) {
		char[] letters = str.toCharArray();
		HashSet<Character> uniqueChars = new HashSet<Character>();
		char[] newSequence = new char[siz];
		int maxLength = 0;

		for (int i = 0; i < siz; i++) {
			Character uniqueChar = new Character(letters[i]);
			uniqueChars.add(uniqueChar);
		}

		for (Character firstChar : uniqueChars) {
			for (Character secondChar : uniqueChars) {
				int newSeqCntr = 0;
				for (int i = 0; i < letters.length; i++) {
					if ((letters[i] == firstChar) || (letters[i] == secondChar)) {
						newSequence[newSeqCntr] = letters[i];
						newSeqCntr++;
					}
				}

				if (validateAlternatingSequence(newSequence, newSeqCntr)) {
					maxLength = Math.max(maxLength, newSeqCntr);
				}
			}
		}

		return (maxLength < 2 ? 0: maxLength);
	}

	public static boolean validateAlternatingSequence(char[] newSeq, int length) {
		for (int i = 0; i < length-1; i++) {
			if (newSeq[i] == newSeq[i+1]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		String s = in.next();

		System.out.println(findLongestRepeatingString(len, s));
	}
}