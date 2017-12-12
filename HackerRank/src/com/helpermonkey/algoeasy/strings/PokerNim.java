package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

/* Hacker Rank - Introduction to Misere Nim */
public class PokerNim {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();// no. of test cases
		int n = 0;
		int k = 0;

		for (int i = 0; i < g; i++) {
			n = in.nextInt();
			k = in.nextInt();
			int[] stones = new int[n];

			int xorSum = 0;

			for (int j = 0; j < n; j++) {
				stones[j] = in.nextInt();
				xorSum = xorSum ^ stones[j];
			}
			
			/** This is the same game as a simple Nim game, because the power to add some chips by one player can be nullified by the other player
			 * as they also have the same number of turns to add/remove, so the add does not have any effect on the chances of someone to win...
			 * so play this as a normal nim game using xor.
			 */
			if (xorSum == 0)
				System.out.println("Second");
			else
				System.out.println("First");
		}
	}

}