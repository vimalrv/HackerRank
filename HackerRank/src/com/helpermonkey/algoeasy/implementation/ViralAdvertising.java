package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class ViralAdvertising {

	public static int findNumberOfPeopleLikingAdvertisement(int noOfDays) {
		double m = 5;
		int noOfPeopleLiked = 0;
		double pplLikedToday = 0;

		for (int i = 0; i < noOfDays; i++) {
			pplLikedToday = Math.floor(m / 2);
			noOfPeopleLiked += pplLikedToday;
			m = pplLikedToday * 3;
		}

		return noOfPeopleLiked;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(findNumberOfPeopleLikingAdvertisement(n));

	}
}