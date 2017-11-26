package com.helpermonkey.algR2;

import java.util.Arrays;
import java.util.Scanner;

/* Hacker Rank - Minimum Absolute Difference in an array */
public class MinAbsDiff {

	static String findMinDiff(int[] arr, int n) {

		Arrays.sort(arr);

		StringBuilder s = new StringBuilder("");
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] - arr[i] == diff) {
				// s.append(arr[i] + " " + arr[i + 1] + " ");
				// do nothing
			}
			if (arr[i + 1] - arr[i] < diff) {
				diff = arr[i + 1] - arr[i];
				s.setLength(0);
				// s.append(arr[i] + " " + arr[i + 1] + " ");
				s.append(diff);
			}
		}

		return s.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		System.out.println(findMinDiff(ar, n));
	}

}
