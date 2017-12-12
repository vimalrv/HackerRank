package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.Scanner;

public class DivisibleByK {

	static int solveProblem(int n, ArrayList<Integer> alist, int k) {

		int cntr = 0;
		for (int i = 0; i < alist.size(); i++) {
			for (int j = 0; j < alist.size(); j++) {
				
				if (j != i) {
					int valueI = alist.get(i);
					int valueJ = alist.get(j);
					int isDivisible = (valueI + valueJ) % k;
					if( (i<j) && isDivisible == 0) {
						cntr++;
					}
				}
			}
		}

		return cntr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		ArrayList<Integer> alist = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			alist.add(in.nextInt());
		}

		int result = solveProblem(n, alist, k);

		System.out.println(result);
	}
}
