package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.Scanner;

public class Chocolate {

	static int solveProblem(int n, ArrayList<Integer> alist, int day, int m) {

		int cntr = 0;
		for (int i = 0; i < alist.size(); i++) {
			int sum = 0;
			for (int k = 0; k < m; k++) {
				int index = i + k;
				if (index < alist.size()) {
					sum += alist.get(index);
				}
			}
			if (sum == day) {
				cntr++;
			}
		}

		return cntr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		ArrayList<Integer> alist = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			alist.add(in.nextInt());
		}

		int d = in.nextInt();
		int m = in.nextInt();

		int result = solveProblem(n, alist, d, m);

		System.out.println(result);
	}
}
