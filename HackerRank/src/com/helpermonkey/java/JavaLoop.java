package com.helpermonkey.java;

import java.util.Scanner;

class JavaLoop {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// Output
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + " = " + (n*i));
		}
	}
}
