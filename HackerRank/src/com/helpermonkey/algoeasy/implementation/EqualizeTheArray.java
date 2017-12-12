package com.helpermonkey.algoeasy.implementation;

import java.util.HashMap;
import java.util.Scanner;

public class EqualizeTheArray {

	public static int findMinDeletions(int[] numbers) {
		HashMap<Integer, Integer> sameNumber = new HashMap<Integer, Integer>();
		
		int maxCnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (sameNumber.containsKey(numbers[i])) {
				int cnt = sameNumber.get(numbers[i]);
				cnt += 1;
				if(maxCnt < cnt) {
					maxCnt = cnt;
				}
				sameNumber.put(numbers[i], cnt);
			} else {
				sameNumber.put(numbers[i], 1);
			}
		}

		return numbers.length - maxCnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}

		System.out.println(findMinDeletions(c));

		in.close();
	}
}