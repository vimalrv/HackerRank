package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class SortingTutorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int v = in.nextInt();

		int n = in.nextInt();
		int[] s = new int[n];

		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}

		for (int i = 0; i < s.length; i++) {
			if (s[i] >= v) {
				System.out.println(i);
				break;
			}
		}
	}
}