package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class JumpingOnTheCloudsTwo {

	public static int findMinJumps(int[] clouds) {
		int noOfJumps = 0;

		for (int i = 0; i < clouds.length - 1; i++) {
			if (clouds[i + 1] == 1 || (i < clouds.length - 2 && clouds[i + 2] == 0)) {
				i++;
			}
			noOfJumps++;
		}

		return noOfJumps;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}

		System.out.println(findMinJumps(c));

		in.close();
	}
}