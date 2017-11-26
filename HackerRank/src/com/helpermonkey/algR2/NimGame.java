package com.helpermonkey.algR2;

import java.util.Scanner;

/* Hacker Rank - Introduction to Nim Game */
public class NimGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();// no. of test cases
		int n = 0;

		for (int i = 0; i < g; i++) {
			n = in.nextInt();
			int stoneCount, xorSum = 0;
			for (int j = 0; j < n; j++) {
				stoneCount = in.nextInt();
				xorSum = xorSum ^ stoneCount;
			}

			if (xorSum == 0)
				System.out.println("Second");
			else
				System.out.println("First");
		}
	}

}