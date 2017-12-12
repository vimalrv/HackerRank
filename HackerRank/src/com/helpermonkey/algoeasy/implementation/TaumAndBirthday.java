package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class TaumAndBirthday {

	public static long findCostForGifts(long noOfBlackGifts, long noOfWhiteGifts, long blackPrice, long whitePrice,
			long colorSwapPrice) {
		long totalPrice = 0;

		long blackSwapPrice = blackPrice + colorSwapPrice;
		if (blackSwapPrice < whitePrice) {
			totalPrice = (noOfBlackGifts * blackPrice) + (noOfWhiteGifts * blackSwapPrice);
			return totalPrice;
		}

		long whiteSwapPrice = whitePrice + colorSwapPrice;
		if (whiteSwapPrice < blackPrice) {
			totalPrice = (noOfBlackGifts * whiteSwapPrice) + (noOfWhiteGifts * whitePrice);
			return totalPrice;
		}

		totalPrice = (noOfBlackGifts * blackPrice) + (noOfWhiteGifts * whitePrice);
		return totalPrice;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long b = in.nextLong();
			long w = in.nextLong();
			long x = in.nextLong();
			long y = in.nextLong();
			long z = in.nextLong();

			System.out.println(findCostForGifts(b, w, x, y, z));
		}

		in.close();
	}
}