package com.helpermonkey.java;

import java.util.Scanner;

class Regex {

	static void splitString(String a) {

		// [A-Za-z !,?._'@]+
		a = a.trim();
		String[] strArr = a.split("[ !,?._'@]+");

		int length = strArr.length;
		if (a == null || a.isEmpty()) {
			length = 0;
		}
		System.out.println(length);

		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		scan.close();
		splitString(a);
	}
}
