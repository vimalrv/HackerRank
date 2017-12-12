package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class MiniMax {

	public static long[] findMinMaxSum(int siz, long[] numbers) {
		long minSum = 0;
		long maxSum = 0;
		long minNumber = 999999999999L;
		long maxNumber = 0;
		
		for (int i = 0; i < siz; i++) {
			minSum += numbers[i];
			maxSum += numbers[i];
			if(numbers[i]<minNumber) {
				minNumber = numbers[i];
			}
			if(numbers[i]>maxNumber) {
				maxNumber = numbers[i];
			}
		}
		
		minSum = minSum - maxNumber;
		maxSum = maxSum - minNumber;
		
		return new long[] { minSum, maxSum };
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = 5;
		long[] ar = new long[n];

		for (int ar_r = 0; ar_r < n; ar_r++) {
			ar[ar_r] = in.nextLong();
		}

		long[] result = findMinMaxSum(n, ar);
		System.out.println(result[0] + " " + result[1]);
	}
}