package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class FairRations {

	public static String findPossibleRation(int[] peopleInQueue, int sum) {
		if (sum % 2 != 0) {
			return "NO";
		}

		int count = 0;
		for (int i = 0; i < peopleInQueue.length - 1; i++) {
			if (peopleInQueue[i] % 2 != 0) {
				peopleInQueue[i] = peopleInQueue[i] + 1;
				peopleInQueue[i + 1] = peopleInQueue[i + 1] + 1;
				count += 2;
			}
		}

		return "" + count;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int B[] = new int[N];
		int sum = 0;
		for (int B_i = 0; B_i < N; B_i++) {
			B[B_i] = in.nextInt();
			sum += B[B_i];
		}

		System.out.println(findPossibleRation(B, sum));

		in.close();
	}
}