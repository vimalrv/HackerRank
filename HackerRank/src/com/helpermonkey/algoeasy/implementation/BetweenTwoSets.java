package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class BetweenTwoSets {

	static int findMin(int[] arr) {
		int min = 999999999;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}

	static int findMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	static int getTotalX(int[] a, int[] b) {
		int min = Math.min(findMin(a), findMin(b));
		int max = Math.max(findMax(a), findMax(b));

		int x = min;
		boolean validA = true;
		boolean validB = true;
		int validXCntr = 0;

		do {
			// x / a
			for (int i = 0; i < a.length; i++) {
				if (x % a[i] > 0) {
					validA = false;
					break;
				}
			}
			if (validA) {
				// b / x
				for (int i = 0; i < b.length; i++) {
					if (b[i] % x > 0) {
						validB = false;
						break;
					}
				}
			}
			if (validA && validB) {
				// System.out.println("valid x:"+x);
				validXCntr++;
			} else {
				validA = true;
				validB = true;
			}
			x++;
		} while (x <= max);

		return validXCntr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}
		int total = getTotalX(a, b);
		System.out.println(total);
	}
}