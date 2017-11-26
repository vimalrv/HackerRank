package com.helpermonkey.java;

import java.util.Scanner;

class JavaStrings {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		int length = A.length() + B.length();
		System.out.println(length);

		int value = A.compareTo(B);
		if (value > 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		String ANew = A.toUpperCase().charAt(0) + A.substring(1);
		String BNew = B.toUpperCase().charAt(0) + B.substring(1);
		System.out.println(ANew + " " + BNew);

	}
}
