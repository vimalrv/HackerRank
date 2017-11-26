package com.helpermonkey.solved;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_Electronics {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();

		int[] keyboardPrices = new int[n];
		for (int i = 0; i < n; i++) {
			keyboardPrices[i] = in.nextInt();
		}

		int[] usbPrices = new int[m];
		for (int i = 0; i < m; i++) {
			usbPrices[i] = in.nextInt();
		}

		Arrays.sort(keyboardPrices);

		Arrays.sort(usbPrices);

		ArrayList<Integer> possibleBuys = new ArrayList<Integer>();

		if (keyboardPrices[0] + usbPrices[0] > s) {
			System.out.println("-1");
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int purchase = keyboardPrices[i] + usbPrices[j];
					if (purchase <= s) {
						possibleBuys.add(purchase);
					}
				}
			}
			Collections.sort(possibleBuys);
			System.out.println(possibleBuys.get(possibleBuys.size()-1));
		}
	}
}