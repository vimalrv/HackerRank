package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class AngryProfessor {

	public static String findIfCalssIsCancelled(int numberOfStndts, int threshold, int[] timeOfComingToClass) {
		int studentsOnTime = 0;

		for (int i = 0; i < timeOfComingToClass.length; i++) {
			if (timeOfComingToClass[i] <= 0) {
				studentsOnTime += 1;
			}
		}

		if (studentsOnTime < threshold) {
			return "YES";
		} else {
			return "NO";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int numberOfStndts = in.nextInt();
			int threshold = in.nextInt();

			int[] timeOfComingToClass = new int[numberOfStndts];
			for (int j = 0; j < numberOfStndts; j++) {
				timeOfComingToClass[j] = in.nextInt();
			}

			System.out.println(findIfCalssIsCancelled(numberOfStndts, threshold, timeOfComingToClass));
		}

	}
}