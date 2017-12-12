package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class BeautifulDaysAtTheMoves {

	public static long reverse(long x) {
		String s = "" + x;
		char[] rxArr = s.toCharArray();

		String rs = "";
		for (int i = (rxArr.length - 1); i >= 0; i--) {
			rs += rxArr[i];
		}

		long rx = Long.parseLong(rs);
		return rx;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long i = in.nextLong();
		long j = in.nextLong();
		long k = in.nextLong();
		
		int cntr = 0;

		for (long p = i; p <= j; p++) {
			double diff = (p - reverse(p));
			double divisible = diff / k;
			long absValue = (long) divisible;
			if(divisible == absValue) {
				cntr++;
			}
		}
		
		System.out.println(cntr);
	}
}