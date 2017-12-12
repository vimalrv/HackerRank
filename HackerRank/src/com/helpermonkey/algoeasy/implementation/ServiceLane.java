package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class ServiceLane {

	public static int findWhichVehicle(int[] segments, int startSegment, int endSegment) {
		int truck = 3;

		int largestVehicle = truck;

		for (int i = startSegment; i <= endSegment; i++) {
			int segmentSize = segments[i];

			if (largestVehicle > segmentSize) {
				largestVehicle = segmentSize;
			}
		}

		return largestVehicle;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();

		int[] segments = new int[n];
		for (int h_i = 0; h_i < n; h_i++) {
			segments[h_i] = in.nextInt();
		}

		for (int h_t = 0; h_t < t; h_t++) {
			int i = in.nextInt();
			int j = in.nextInt();

			System.out.println(findWhichVehicle(segments, i, j));

		}
	}
}