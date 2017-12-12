package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class MilkyBarFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int c_i = 0; c_i < t; c_i++) {
			int dollarsInHand = in.nextInt();
			int costOfMilkyBar = in.nextInt();
			int exchangeThreshold = in.nextInt();

			int noOfMilkyBar = dollarsInHand / costOfMilkyBar;
			int wrappersInHand = noOfMilkyBar;

			while (wrappersInHand >= exchangeThreshold) {
				int exchangedMilkyBar = wrappersInHand / exchangeThreshold;
				wrappersInHand = wrappersInHand % exchangeThreshold + exchangedMilkyBar;
				noOfMilkyBar += exchangedMilkyBar;
			}

			System.out.println(noOfMilkyBar);
		}

		in.close();
	}
}