package com.helpermonkey.algoeasy.sorting;
import java.util.Scanner;

public class Solution_InsertionSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] intArr = new int[n];

		for (int i = 0; i < n; i++) {
			int str = in.nextInt();
			intArr[i] = str;
		}

		int newVal = intArr[n-1];
		for (int i = n - 1; i >= 1; i--) {
			
			if (newVal >= intArr[i - 1]) {
				intArr[i] = newVal;
				System.out.println(valuesToString(intArr));
				break;
			} else {
				intArr[i] = intArr[i - 1];
				System.out.println(valuesToString(intArr));
				if(i==1) {
					intArr[i-1] = newVal;
					System.out.println(valuesToString(intArr));
				}
			}
		}

	}
	
	static String valuesToString(int[] arr) {
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i] + " ";
		}
		return s.trim();
	}
}

