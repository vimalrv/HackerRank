package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;
import java.util.TreeSet;

public class ManasaAndStones {

	public static void findPossibleLastStones(int noOfStones, int a, int b) {
		TreeSet<Integer> finalStones = new TreeSet<Integer>();

		for (int i = 0; i < noOfStones; i++) {
			int sum = (i * a) + ((noOfStones - 1 - i) * b);
			finalStones.add(sum);
		}

		for (Integer e : finalStones) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int grid_i = 0; grid_i < t; grid_i++) {
			int noOfStones = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();

			findPossibleLastStones(noOfStones, a, b);
		}

		in.close();
	}
}