package com.helpermonkey.solved;

import java.util.Scanner;

public class Solution_CatAndMouse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();

			if (x < y && y <= z) {
				System.out.println("Cat B");
			} else if (y < x && x <= z) {
				System.out.println("Cat A");
			} else if (z < x && x <= y) {
				System.out.println("Cat A");
			} else if (z < y && y <= x) {
				System.out.println("Cat B");
			} else {
				int xValue = 0;
				int yValue = 0;

				if (z < y && z > x) {
					xValue = (z - x);
					yValue = (y - z);
				} else if (z > y && z < x) {
					xValue = (x - z);
					yValue = (z - y);
				}

				if (xValue < yValue) {
					System.out.println("Cat A");
				} else if (xValue > yValue) {
					System.out.println("Cat B");
				} else {
					System.out.println("Mouse C");
				}
			}
		}
	}
}