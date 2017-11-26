package com.helpermonkey.solved;
import java.util.Scanner;

public class Solution_BonApetit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] types = new int[n];
		int totalBill = 0;
		
		for (int i = 0; i < n; i++) {
			types[i] = in.nextInt();
			if (i != k) {
				totalBill += types[i];
			}
		}
		
		int charged = in.nextInt();
		int share = totalBill / 2;
		
		if(share == charged) {
			System.out.println("Bon Appetit");
		}else {
			System.out.println(charged - share);
		}

		
	}
}