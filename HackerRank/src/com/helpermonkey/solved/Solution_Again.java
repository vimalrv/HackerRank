package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution_Again {

	static int solveProblem(int n, ArrayList<Integer> alist) {

		HashMap<Integer, ArrayList<Integer>> commonBirds = new HashMap<Integer, ArrayList<Integer>>();
		int cntr = 0;
		for (int i = 0; i < alist.size(); i++) {
			for (int j = 0; j < alist.size(); j++) {
				if (i != j) {
					int birdType = alist.get(i);
					if (birdType == alist.get(j)) {
						if (commonBirds.containsKey(cntr)) {
//							duplicate = commonBirds.get(birdType);
//							duplicate.add(birdType);
//							commonBirds.put(cntr, duplicate);
//						} else {
//							cntr = 1;
//							commonBirds.put(cntr, new ArrayList(birdType));
						}
					}
				}
			}
		}

		Integer[] keys = new Integer[commonBirds.size()];
		keys = (Integer[]) commonBirds.keySet().toArray(keys);
		Arrays.sort(keys);
		ArrayList<Integer> birdTypes = commonBirds.get(keys[0]);
		Collections.sort(birdTypes);
		return birdTypes.get(0);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		ArrayList<Integer> alist = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			alist.add(in.nextInt());
		}

		int result = solveProblem(n, alist);

		System.out.println(result);
	}
}
