package com.helpermonkey.algR2;

import java.util.Scanner;

/* Hacker Rank - Introduction to Misere Nim */
public class MisereNim {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();// no. of test cases
		int n = 0;

		for (int i = 0; i < g; i++) {
			n = in.nextInt();
			int[] stones = new int[n];

			for (int j = 0; j < n; j++) {
				stones[j] = in.nextInt();
			}

			/*
			 * In a single pile, if more than one stones exist then first player will
			 * always win by leaving the last stone for second player to pick up
			 */
			if (stones.length == 1) {
				if (stones[0] > 1) {
					System.out.println("First");
				} else {
					System.out.println("Second");
				}

				continue;
			}

			int stoneCount = 0;
			int xorSum = 0;

			for (int s = 0; s < stones.length; s++) {
				stoneCount += stones[s];
				xorSum = xorSum ^ stones[s];
			}

			/*
			 * If sum of all stones equals the total piles, all piles have a single (1)
			 * stone. For even number of piles, first player will always win.
			 */
			if (stoneCount == stones.length) {
				if (stoneCount % 2 == 0) {
					System.out.println("First");
				} else {
					System.out.println("Second");
				}

				continue;
			}

			/*
			 * For all other cases, the xor value determines winner. If xor value = 0,
			 * then second player will always win as all piles (stones) can be paired.
			 */
			if (xorSum == 0)
				System.out.println("Second");
			else
				System.out.println("First");
		}
	}

}