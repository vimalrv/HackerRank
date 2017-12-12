package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class SequenceEquation {

	public static void printoutPPY(int[] numbers) {
		int indexOfX = 0;
		for (int x = 1; x <= numbers.length; x++) {
			for (int y = 1; y <= numbers.length; y++) {
				if (numbers[y - 1] == x) {
					indexOfX = y;
					break;
				}
			}

			for (int y = 1; y <= numbers.length; y++) {
				if (numbers[y - 1] == indexOfX) {
					System.out.println(y);
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int[] stickLengths = new int[t];

		for (int i = 0; i < t; i++) {
			stickLengths[i] = in.nextInt();
		}

		printoutPPY(stickLengths);
	}
}