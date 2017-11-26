package com.helpermonkey.solved;
import java.util.Scanner;

public class Solution_Valleys {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String str = in.nextLine();

		char[] steps = str.toCharArray();
		int[] stepValue = new int[n];
		
		int valleyCount = 0;
		int currentLevel = 0;
		int seaLevel = 0;
		boolean valleyStart = false;
		
		for (int i = 0; i < n; i++) {
			if ('U' == steps[i]) {
				stepValue[i] = 1;
			} else if ('D' == steps[i]) {
				stepValue[i] = -1;
			} else {
				stepValue[i] = 0;
			}
			
			currentLevel += stepValue[i];
			if (currentLevel < seaLevel) {
				valleyStart = true;
			}
			if (valleyStart && (currentLevel == seaLevel)) {
				valleyCount++;
				valleyStart = false;
			}
		}

		System.out.println(valleyCount);
	}
}