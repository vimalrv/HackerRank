package com.helpermonkey.solved;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_Stock {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] types = new int[n];
		for (int types_i = 0; types_i < n; types_i++) {
			types[types_i] = in.nextInt();
		}

		Arrays.sort(types);
		System.err.println(Arrays.toString(types));

		int sockPair = 0;
		int currentColor = types[0];
		// int pairCntr = 0;

		for (int i = 0; i < n - 1; i++) {
			currentColor = types[i];
			if (currentColor == types[i + 1]) {
				sockPair++;
				i = i + 1;
			} 
		}
		System.out.println(sockPair);
	}
}