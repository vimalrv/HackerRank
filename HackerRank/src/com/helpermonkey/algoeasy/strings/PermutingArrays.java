package com.helpermonkey.algoeasy.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Hacker Rank - Permuting Two Arrays */
public class PermutingArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int[] ar = new int[t];
		for (int i = 0; i < t; i++) {

			int n = in.nextInt();
			int k = in.nextInt();

			Integer[] arr1 = new Integer[n];
			Integer[] arr2 = new Integer[n];
			for (int j = 0; j < n; j++) {
				arr1[j] = in.nextInt();
			}

			for (int j = 0; j < n; j++) {
				arr2[j] = in.nextInt();
			}

			if (isPermutable(arr1, arr2, k)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static boolean isPermutable(Integer[] arr1, Integer[] arr2, int k) {
		// sort in ascending order
		Arrays.sort(arr1);
		// sort in descending order
		Arrays.sort(arr2, Collections.reverseOrder());
		// matching largest with smaller, 2nd largest with 2nd smallest, and so on
		for (int i = 0; i < arr1.length; i++) {
			// if any of those pairs is less than k, return false
			if (arr1[i] + arr2[i] < k) {
				return false;
			}
		}
		// after traversing the whole length, return true
		return true;
	}
}
