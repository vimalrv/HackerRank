package com.helpermonkey.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class JavaList {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		HashMap<Integer, ArrayList<Integer>> rows = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> columnValues = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int d = in.nextInt();
			for (int j = 0; j < d; j++) {
				columnValues.add(new Integer(in.nextInt()));
			}
			rows.put(i, columnValues);
			columnValues = new ArrayList<Integer>();
		}

		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			columnValues = rows.get(x - 1);
			if (columnValues == null || columnValues.isEmpty()) {
				System.out.println("ERROR!");
			}else if (y > columnValues.size()) {
				System.out.println("ERROR!");
			} else {
				Integer value = columnValues.get(y-1);
				if (value == null) {
					System.out.println("ERROR!");
				} else {
					System.out.println(value.intValue());
				}
			}
		}

		in.close();
	}
}
