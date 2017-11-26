package com.helpermonkey.algR2;

import java.util.Scanner;

/* Hacker Rank - Introduction to Maximizing XOR */
public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int L = in.nextInt();
		int R = in.nextInt();
		int xorValue = L ^ R;
		int k = 0;
		while (xorValue >= (int) Math.pow(2, k)) {
			k++;
		}
		System.out.println((int) Math.pow(2, k) - 1);

		// int _l= Integer.parseInt(in.nextLine());
		// int _r= Integer.parseInt(in.nextLine());
		// System.out.println((int)Math.pow(2, Integer.toBinaryString(_l^_r).length())-1);

	}

}