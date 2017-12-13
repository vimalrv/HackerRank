package com.helpermonkey.algoeasy.search;
import java.util.Scanner;

public class Solution_SherlockAndArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arrA = new int[n];
			for (int types_i = 0; types_i < n; types_i++) {
				arrA[types_i] = in.nextInt();
			}
			
			boolean isSumExist = false;
			
			//int sumIndex = 1;
			int sumValueLeft = 0;
			int sumValueRight = 0;
			int totalSum = 0;
			for (int j = 0; j < arrA.length; j++) {
				totalSum += arrA[j];
			}
			
			int curSum = 0;
			
			for (int j = 0; j < arrA.length; j++) {
				//sumValueLeft = 0;
				//sumValueRight = 0;
				
				//sumIndex = j;
				sumValueLeft = curSum;
				curSum = curSum + arrA[j];
				sumValueRight = totalSum - curSum;
				
				if(sumValueLeft == sumValueRight) {
					isSumExist = true;
					break;
				}
//				
//				
//				//sum the left
//				for(int j1=0; j1<sumIndex; j1++) {
//					sumValueLeft += arrA[j1];
//				}
//				
//				//sum the right
//				for(int j1=sumIndex+1; j1<arrA.length; j1++) {
//					sumValueRight += arrA[j1];
//				}
//				
//				if(sumValueLeft == sumValueRight) {
//					System.out.println("YES");
//					isSumExist = true;
//					break;
//				}
			}
			if(isSumExist) {
				System.out.println("YES");}
			else {
				System.out.println("NO");
			}
			
		}
	}
}