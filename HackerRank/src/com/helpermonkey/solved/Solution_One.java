package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution_One {

	static int solveProblem(int n, ArrayList<Integer> alist) {

		HashMap<Integer, Integer> commonBirds = new HashMap<Integer, Integer>();
		int cntr = 0;
		int birdTypeHighest = 0;
		;
		ArrayList<Integer> duplicate = new ArrayList<Integer>();
		for (int i = 0; i < alist.size(); i++) {
			for (int j = 0; j < alist.size(); j++) {
				if (i != j) {
					int birdType = alist.get(i);
					if (birdType == alist.get(j)) {
						if (commonBirds.containsKey(birdType)) {
							cntr = commonBirds.get(birdType);
							cntr++;
							commonBirds.put(birdType, cntr);

							if ((birdTypeHighest != 0) && (commonBirds.get(birdTypeHighest) >= cntr)) {
								if (commonBirds.get(birdTypeHighest) == cntr) {
									duplicate.add(birdTypeHighest);
									duplicate.add(birdType);
								}
								birdTypeHighest = birdType;
							}
						} else {
							commonBirds.put(birdType, 1);
							if (birdTypeHighest == 0) {
								birdTypeHighest = birdType;
							}
						}

					}
				}
			}
		}
		if (!duplicate.isEmpty()) {
			Collections.sort(duplicate);
			return duplicate.get(0);
		} else {
			return birdTypeHighest;
		}
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
