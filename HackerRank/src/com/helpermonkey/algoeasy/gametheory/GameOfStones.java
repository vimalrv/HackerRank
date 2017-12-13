package com.helpermonkey.algoeasy.gametheory;

import java.util.Scanner;

public class GameOfStones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();// no. of test cases
		int n = 0;
		for (int i = 0; i < t; i++) {
			n = in.nextInt();
			if (n % 7 < 2) {
				System.out.println("Second");
			} else {
				System.out.println("First");
			}
		}

	}
}