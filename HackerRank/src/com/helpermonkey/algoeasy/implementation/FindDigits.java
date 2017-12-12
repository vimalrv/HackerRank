package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class FindDigits {

	public static int findEvenlyDivisibleDigits(int number) {
		String strNum = "" + number;
		char[] digits = strNum.toCharArray();
		int noOfDigits = 0;

		for (int i = 0; i < digits.length; i++) {
			int divisor = (int) digits[i] - 48;
			if (divisor != 0 && number % divisor == 0) {
				noOfDigits += 1;
			}
		}

		return noOfDigits;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int number = in.nextInt();
			System.out.println(findEvenlyDivisibleDigits(number));
		}

	}
}