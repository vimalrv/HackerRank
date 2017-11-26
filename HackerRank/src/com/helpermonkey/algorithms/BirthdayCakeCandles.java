package com.helpermonkey.algorithms;

import java.util.Scanner;

public class BirthdayCakeCandles {

	public static long findHighCandles(int siz, long[] numbers) {
		long candleCounter = 0;
		long heighestHeight = 0;
		
		for (int i = 0; i < siz; i++) {
			if(numbers[i]>heighestHeight) {
				heighestHeight = numbers[i];
				candleCounter=0;
			}
			if(numbers[i] == heighestHeight) {
				candleCounter++;
			}
		}
		
		return candleCounter;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] ar = new long[n];

		for (int ar_r = 0; ar_r < n; ar_r++) {
			ar[ar_r] = in.nextLong();
		}

		long result = findHighCandles(n, ar);
		System.out.println(result);
	}
}