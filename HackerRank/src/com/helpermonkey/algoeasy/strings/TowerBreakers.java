package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class TowerBreakers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();// no. of test cases
		int n = 0;
		int m = 0;
		for (int i = 0; i < t; i++) {
			n = in.nextInt();
			m = in.nextInt();
			if (m == 1 || n % 2 == 0) {
				System.out.println("2");
			} else {
				System.out.println("1");
			}
		}

	}
}