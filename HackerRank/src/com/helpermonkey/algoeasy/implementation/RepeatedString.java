package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class RepeatedString {

	private static int findACount(String str) {
		int fromIndex = -1;
		int aCntr = 0;
		while ((fromIndex = str.indexOf('a', (fromIndex + 1))) != -1) {
			aCntr += 1;
		}
		return aCntr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();

		int strLength = s.length();
		int aCntr = 0;
		String subStr = "";

		if (n < strLength) {
			subStr = s.substring(0, (int) n);
			aCntr = findACount(subStr);
			System.out.println(aCntr);
		} else {
			long totalCount = 0;
			long q = n / strLength;
			int r = (int) (n % strLength);

			aCntr = findACount(s);
			totalCount = q * aCntr;

			if (r > 0) {
				subStr = s.substring(0, r);
				totalCount += findACount(subStr);
			}
			System.out.println(totalCount);
		}

		in.close();
	}
}