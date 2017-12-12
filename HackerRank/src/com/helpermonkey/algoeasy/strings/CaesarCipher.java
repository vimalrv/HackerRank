package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class CaesarCipher {

	public static String encryptString(int length, String str, int noOfCharToRotate) {
		char[] letters = str.toCharArray();
		StringBuilder encryptedString = new StringBuilder();

		for (int i = 0; i < letters.length; i++) {
			if (Character.isAlphabetic(letters[i])) {
				int asciiValue = (int) letters[i];
				int startAscii = 0;
				int endAscii = 0;
				if (Character.isUpperCase(letters[i])) {
					// ascii value upper case alphabet is A=65 to Z=90
					startAscii = 65;
					endAscii = 90;
				} else {
					// ascii value lower case alphabet is a=97 to z=122
					startAscii = 97;
					endAscii = 122;
				}

				int diff = endAscii - asciiValue;
				if (noOfCharToRotate > diff) {
					int newNoOfCharToRotate = noOfCharToRotate - diff;
					newNoOfCharToRotate = newNoOfCharToRotate % 26;

					if (newNoOfCharToRotate == 0) {
						asciiValue = endAscii;
					} else {
						asciiValue = (startAscii - 1) + newNoOfCharToRotate;
					}
				} else {
					asciiValue = asciiValue + noOfCharToRotate;
				}

				encryptedString.append((char) asciiValue);
			} else {
				// if the letter is not a alphabet, leave it as such...
				encryptedString.append(letters[i]);
			}

		}

		return encryptedString.toString();
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
		int length = in.nextInt();
		String s = in.next();
		int noOfCharToRotate = in.nextInt();

		System.out.println(encryptString(length, s, noOfCharToRotate));
	}
}