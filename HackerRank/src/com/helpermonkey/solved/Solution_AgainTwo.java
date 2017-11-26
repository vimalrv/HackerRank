package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution_AgainTwo {

	static int solveProblem(int n, ArrayList<Integer> alist) {

		HashMap<Integer, Integer> commonBirds = new HashMap<Integer, Integer>();
		int cntr = 0;
		for (int i = 0; i < alist.size(); i++) {
			for (int j = 0; j < alist.size(); j++) {
				if (i != j) {
					int birdType = alist.get(i);
					if (birdType == alist.get(j)) {
						if (commonBirds.containsKey(birdType)) {
							cntr = commonBirds.get(birdType);
							cntr++;
							commonBirds.put(birdType, cntr);
						}
					} else {
						commonBirds.put(birdType, 1);
					}

				}
			}
		}
		
		TreeMap<Integer, TreeSet<Integer>> reverseMap = new TreeMap<>();

		for (Map.Entry<Integer,Integer> entry : commonBirds.entrySet()) {
		    if (!reverseMap.containsKey(entry.getValue())) {
		        reverseMap.put(entry.getValue(), new TreeSet<>());
		    }
		    TreeSet<Integer> keys = reverseMap.get(entry.getValue());
		    keys.add(entry.getKey());
		    reverseMap.put(entry.getValue(), keys);
		}
		
		TreeSet<Integer> treeKeys = new TreeSet(reverseMap.keySet());
		for(Integer key:treeKeys) {
			TreeSet<Integer> birdTypes = reverseMap.get(key);
			
			//return birdTypes.get(0);
		}
		
		return 0;
		
//		TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
//		tree.putAll(reverseMap);
		
		
		
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
