package com.helpermonkey.algoeasy.strings;

import java.util.ArrayList;
import java.util.Scanner;

public class IcreCream {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int j = 0; j < t; j++) {
			int m = scan.nextInt();
			int n = scan.nextInt();
			ArrayList<Integer> prices = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				prices.add(scan.nextInt());
			}

			for (int p = 0; p < prices.size(); p++) {
				boolean found = false;
				int pick = prices.get(p);

				for (int k = 1; k < prices.size(); k++) {
					if(p==k)
						continue;

					int curPick = prices.get(k);
					if ((pick + curPick) == m) {
						found = true;
						System.out.println((p <= k ? (p + 1) : (k + 1)) + " " + ((p > k) ? (p + 1) : (k + 1)));
						break;
					}
				}
				if (found)
					break;

			}
		}
	}
}