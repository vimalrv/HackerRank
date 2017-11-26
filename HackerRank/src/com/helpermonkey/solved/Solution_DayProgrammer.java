package com.helpermonkey.solved;

import java.util.Scanner;

public class Solution_DayProgrammer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int days = 0;
		for (int i = 1; i <= 7; i++) {
			if (i % 2 > 0) {
				// odd months
				days += 31;
			} else {
				// even monthselse
				if (i != 2) {
					// even months other than Feb
					days += 30;
				} else {

					// feb, need to check for leap year etc.
					// julian calendar
					if ((n >= 1700 && n <= 1917)) {
						if (n % 4 == 0) {
							// leap year
							days += 29;
						} else {
							days += 28;
						}
					} else {
						// Gregorian Calendare
						// if ((n >= 1919 && n <= 2700))
						if (n % 400 == 0) {
							days += 29;
						} else {
							if (n % 100 != 0 && (n % 4 == 0)) {
								// leap year
								days += 29;
							} else {
								days += 28;
							}
						}
					}
					if (n == 1918) {
						// cusp year, so reduce 13 days
						days = days - 13;
					}
				}
			}
		}

		// for Aug
		days += 31;

		int toAdd = 256 - days;

		System.out.println(toAdd + ".09." + n);
	}
}