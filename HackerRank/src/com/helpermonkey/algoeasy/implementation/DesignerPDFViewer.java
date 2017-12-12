package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class DesignerPDFViewer {

	public static int findAreaOfWord(int[] heightArr, String word) {
		int tallestChar = 0;

		char[] wordArr = word.toCharArray();
		int wordLength = wordArr.length;

		for (int i = 0; i < wordLength; i++) {
			int alphabet = (int) wordArr[i];

			// since small a ascii value is 97
			alphabet = alphabet - 97;
			int heightOfAlpha = heightArr[alphabet];
			if (heightOfAlpha > tallestChar) {
				tallestChar = heightOfAlpha;
			}
		}

		return (wordLength * tallestChar);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] h = new int[26];
		for (int h_i = 0; h_i < 26; h_i++) {
			h[h_i] = in.nextInt();
		}
		String word = in.next();

		System.out.println(findAreaOfWord(h, word));

	}
}