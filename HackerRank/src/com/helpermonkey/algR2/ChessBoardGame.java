package com.helpermonkey.algR2;

import java.util.Scanner;

/* Hacker Rank - A Chessboard Game */
public class ChessBoardGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();// no. of test cases
		int x = 0;
		int y = 0;
		for (int i = 0; i < t; i++) {
			x = in.nextInt();
			y = in.nextInt();

			x = x % 4;
			y = y % 4;
			if ((y == 0) || (y == 3) || (x == 0) || (x == 3)) {
				System.out.println("First");
			} else {
				System.out.println("Second");
			}
		}
	}
}