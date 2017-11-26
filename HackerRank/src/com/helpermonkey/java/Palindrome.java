package com.helpermonkey.java;

import java.util.Scanner;

class Palindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		boolean isPalindrome = true;
		char[] strArr = str.toCharArray();
		int midPoint = strArr.length / 2;
		int reverseCntr = strArr.length - 1;
		
		for (int i = 0; i < midPoint; i++) {
			if (strArr[i] != strArr[reverseCntr]) {
				System.out.println("No");
				isPalindrome = false;
				break;
			}
			reverseCntr--;
		}

		if (isPalindrome)
			System.out.println("Yes");

		scanner.close();
	}
}
