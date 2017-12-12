package com.helpermonkey.algoeasy.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class CutTheSticks {

	public static void printoutEachCut(int[] stickLengths) {
		boolean stillHave = true;
		int numberOfSticksLeft = stickLengths.length;

		ArrayList<Integer> stickList = new ArrayList<Integer>();

		while (stillHave) {
			int minStickSize = 999999999;
			for (int j = 0; j < stickLengths.length; j++) {
				if (stickLengths[j] > 0 && minStickSize > stickLengths[j]) {
					minStickSize = stickLengths[j];
				}
			}

			System.out.println(numberOfSticksLeft);
			for (int i = 0; i < stickLengths.length; i++) {
				if (stickLengths[i] > 0) {
					stickLengths[i] = stickLengths[i] - minStickSize;
					if (stickLengths[i] <= 0) {
						numberOfSticksLeft = numberOfSticksLeft - 1;
						if (numberOfSticksLeft <= 0) {
							stillHave = false;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int[] stickLengths = new int[t];

		for (int i = 0; i < t; i++) {
			stickLengths[i] = in.nextInt();
		}

		printoutEachCut(stickLengths);
	}
}