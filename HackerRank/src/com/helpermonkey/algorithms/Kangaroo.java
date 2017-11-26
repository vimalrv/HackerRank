package com.helpermonkey.algorithms;

import java.util.Scanner;

public class Kangaroo {

	static String kangarooRun(int x1, int v1, int x2, int v2) {
		int k1dist = x1;
		int k2dist = x2;
		do {
			k1dist += v1;
			k2dist += v2;
			if (k1dist == k2dist) {
				return "YES";
			}
		} while (k1dist < k2dist);
		
		return "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		String result = kangarooRun(x1, v1, x2, v2);
		System.out.println(result);
	}
}