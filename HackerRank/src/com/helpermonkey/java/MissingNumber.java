package com.helpermonkey.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class MissingNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		HashMap<Integer, Integer> list1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> list2 = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int number = scanner.nextInt();
			int freq;
			if (list1.containsKey(number)) {
				freq = list1.get(number);
				freq++;
				list1.put(number, freq);
			} else {
				list1.put(number, 1);
			}
		}

		int m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			int number = scanner.nextInt();
			int freq;
			if (list2.containsKey(number)) {
				freq = list2.get(number);
				freq++;
				list2.put(number, freq);
			} else {
				list2.put(number, 1);
			}
		}

		ArrayList<Integer> missing = new ArrayList<Integer>();
		Set<Integer> keys = list1.keySet();
		for (Integer key : keys) {
			int freq = list1.get(key);
			if (list2.containsKey(key)) {
				int freq2 = list2.get(key);
				if (freq != freq2) {
					missing.add(key);
				}
			} else {
				missing.add(key);
			}
		}

		Collections.sort(missing);
		for (Integer mvalue : missing) {
			System.out.println(mvalue + " ");

		}

		scanner.close();
	}

}
