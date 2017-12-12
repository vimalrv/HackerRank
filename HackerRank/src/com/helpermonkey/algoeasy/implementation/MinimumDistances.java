package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class MinimumDistances {

	public static int findMinDistance(int[] numbers) {
		int minDistance = 999999999;
		int distance = -1;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					distance = j - i;
					break;
				}
			}
			if (minDistance > distance && distance != -1) {
				minDistance = distance;
			}
		}
		
		if(minDistance == 999999999) {
			minDistance = -1;
		}

		return minDistance;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}

		System.out.println(findMinDistance(A));
	}
}