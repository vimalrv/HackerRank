package com.helpermonkey.datastructure;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] s = new int[n];

		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}

		for (int i = (s.length - 1); i >= 0; i--) {
				System.out.print(s[i] + " ");
		}
	}
}