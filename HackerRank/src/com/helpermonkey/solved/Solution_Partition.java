package com.helpermonkey.solved;
import java.util.Scanner;

public class Solution_Partition {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] intArr = new int[n];
		for (int i = 0; i < n; i++)
			intArr[i] = in.nextInt();

		int p = intArr[0];
		// TreeSet<Integer> leftArr = new TreeSet<Integer>();
		// TreeSet<Integer> rightArr = new TreeSet<Integer>();
		int[] leftArr = new int[n];
		int[] rightArr = new int[n];
		int leftCntr = 0;
		int rightCntr = 0;
		for (int i = 1; i < n; i++) {
			if (intArr[i] < p) {
				leftArr[leftCntr] = intArr[i];
				leftCntr++;
			} else if (intArr[i] > p) {
				rightArr[rightCntr] = intArr[i];
				rightCntr++;
			}
		}

		printResult(leftArr, leftCntr);
		System.out.print(p + " ");
		printResult(rightArr, rightCntr);

	}

	public static void printResult(int[] arr, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
