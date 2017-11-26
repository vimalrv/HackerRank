package com.helpermonkey.algR2;

import java.util.Scanner;

/* Hacker Rank - Introduction to Misere Nim */
public class NimbleGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();// no. of test cases

		while (t-- > 0) {
			int n = in.nextInt();
			int xorValue = 0;
			for (int i = 0; i < n; i++) {
				if (in.nextInt() % 2 == 1) {
					xorValue ^= i;
				}
			}
			if (xorValue == 0)
				System.out.println("Second");
			else
				System.out.println("First");
		}
	}

}