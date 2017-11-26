package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_Alice {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] scores = new int[n];

		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o2).compareTo(o1);
			}
		};

		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		TreeSet<Integer> t = new TreeSet<Integer>(c);

		for (int types_i = 0; types_i < n; types_i++) {
			int score = in.nextInt();
			scores[types_i] = score;
			if (!t.contains(score)) {
				scoreList.add(scores[types_i]);
				t.add(score);
			}

		}

		Arrays.sort(scores);

		int m = in.nextInt();
		int[] aliceScores = new int[m];
		for (int types_i = 0; types_i < m; types_i++) {
			aliceScores[types_i] = in.nextInt();

			int index = Collections.binarySearch(scoreList, aliceScores[types_i], c);
			if (index < 0) {
				index = Math.abs(index);
			} else {
				index++;
			}
			System.out.println(index);
		}


		// TreeSet<Integer> t = new TreeSet<Integer>(c);
		// List<Integer> l = new ArrayList<Integer>();
		// for(int i=0;i<n;i++) {
		// int data = in.nextInt();
		// if(!t.contains(data)) {
		// t.add(data);
		// l.add(data);
		// }
		// }
		// // System.out.println(l);
		// int m = in.nextInt();
		// for(int i=0;i<m;i++) {
		// int data = in.nextInt();
		// int index = Collections.binarySearch(l,data,c);
		// if(index<0) {
		// index = Math.abs(index);
		// }
		// else {
		// index++;
		// }
		// System.out.println(index);
		// }
		// }

//		HashMap<Integer, Integer> ranks = new HashMap<Integer, Integer>();
//		int genRank = 1;
//
//		int[] sortedScores = new int[n];
//		int countdown = 0;
//		for (int i = n - 1; i >= 0; i--) {
//			sortedScores[i] = scores[countdown];
//			countdown++;
//			if (!ranks.containsKey(scores[i])) {
//				ranks.putIfAbsent(scores[i], genRank);
//				genRank++;
//			}
//		}
//		scores = sortedScores;
//
//		int aliceRank = 0;
//		int aliceScore = 0;
//		for (int i = 0; i < m; i++) {
//			aliceRank = 0;
//			aliceScore = aliceScores[i];
//
//			for (Integer score : ranks.keySet()) {
//				if (aliceScore < score) {
//					aliceRank = ranks.get(score) + 1;
//				}
//				if (aliceScore == score) {
//					aliceRank = ranks.get(score);
//				}
//			}
//			if (aliceScore > scores[0]) {
//				aliceRank = 1;
//			}
//			System.out.println(aliceRank);
//		}

	}
}