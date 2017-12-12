package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class UtopianTree {

	public static int findHeightOfUtopianTree(int noOfCycles) {
		int height = 1;

		for (int i = 1; i <= noOfCycles; i++) {
			// this is summer
			if (i % 2 == 0) {
				height = height + 1;
			} else {
				height = height + height;
			}
		}

		return height;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int h_t = 0; h_t < t; h_t++) {
			int n = in.nextInt();

			System.out.println(findHeightOfUtopianTree(n));
		}
	}
}