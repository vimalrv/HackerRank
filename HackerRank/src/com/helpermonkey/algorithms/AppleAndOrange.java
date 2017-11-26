package com.helpermonkey.algorithms;

import java.util.Scanner;

public class AppleAndOrange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();// start point of sam's house
		int t = in.nextInt();// end point of sam's house
		int a = in.nextInt();// point of apple tree
		int b = in.nextInt();// point of orange tree

		int m = in.nextInt();// no. of apples
		int n = in.nextInt();// no. of oranges

		int applesFall = 0;
		int orangesFall = 0;

		int[] apple = new int[m];
		for (int apple_i = 0; apple_i < m; apple_i++) {
			apple[apple_i] = in.nextInt();
			int fallPosition = a + apple[apple_i];
			if (fallPosition >= s && fallPosition <= t) {
				applesFall++;
			}
		}
		int[] orange = new int[n];
		for (int orange_i = 0; orange_i < n; orange_i++) {
			orange[orange_i] = in.nextInt();
			int fallPosition = b + orange[orange_i];
			if (fallPosition >= s && fallPosition <= t) {
				orangesFall++;
			}
		}
		System.out.println(applesFall);
		System.out.println(orangesFall);

	}
}