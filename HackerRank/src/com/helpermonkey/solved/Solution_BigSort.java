package com.helpermonkey.solved;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution_BigSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// BigInteger[] bigArr = new BigInteger[n];
		// TreeMap<BigInteger, Integer> tree = new TreeMap<BigInteger, Integer>();
		ArrayList<String> strList = new ArrayList<String>();

		// String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			String str = in.next();
			strList.add(str);
			// BigInteger intVal = new BigInteger(str);
			// tree.put(intVal, new Integer(1));
		}

		// for (int i = 0; i < bigArr.length; i++) {
		// System.out.println(bigArr[i].toString());
		// }

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String i, String j) {
				int n = i.length();
				int m = j.length();
				if (n == m)
					return (i.compareTo(j));

				if (n < m) {
					return -1;
				} else if (n > m) {
					return 1;
				}
				return 0;
			}
		};

		Collections.sort(strList, c);

		for (String sortedValue : strList) {
			System.out.println(sortedValue);
		}
	}
}