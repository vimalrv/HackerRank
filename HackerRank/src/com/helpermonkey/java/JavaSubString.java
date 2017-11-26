package com.helpermonkey.java;

import java.util.Arrays;
import java.util.Scanner;

public class JavaSubString {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
        
        int subStrCntr = s.length() - k;
        

		String[] subStrArr = new String[subStrCntr+1];
		for (int i = 0; i < (subStrCntr+1); i++) {
			subStrArr[i] = s.substring(i, i + k);
		}

		Arrays.sort(subStrArr);

		smallest = subStrArr[0];
		largest = subStrArr[subStrCntr];

		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
