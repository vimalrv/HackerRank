package com.helpermonkey.algomed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class RansomHashMap {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	int numOfMagazoneWords;
	int numOfNoteWords;

	public RansomHashMap(String magazine, int m, String note, int n) {
		String[] magWords = magazine.split(" ");
		String[] noteWords = note.split(" ");

		this.magazineMap = new HashMap<String, Integer>();
		this.noteMap = new HashMap<String, Integer>();

		for (int i = 0; i < magWords.length; i++) {
			if (magazineMap.containsKey(magWords[i])) {
				Integer numOfOccurance = magazineMap.get(magWords[i]);
				numOfOccurance = new Integer(numOfOccurance.intValue() + 1);
				magazineMap.put(magWords[i], numOfOccurance);

			} else {
				magazineMap.put(magWords[i], new Integer(1));
			}
		}

		for (int i = 0; i < noteWords.length; i++) {
			if (noteMap.containsKey(noteWords[i])) {
				Integer numOfOccurance = noteMap.get(noteWords[i]);
				numOfOccurance = new Integer(numOfOccurance.intValue() + 1);
				noteMap.put(noteWords[i], numOfOccurance);

			} else {
				noteMap.put(noteWords[i], new Integer(1));
			}
		}

		numOfMagazoneWords = m;
		numOfNoteWords = n;
	}

	public boolean solve() {
		boolean allMatched = true;

		for (Iterator<String> iterator = noteMap.keySet().iterator(); iterator.hasNext();) {
			String noteWord = iterator.next();
			if (magazineMap.containsKey(noteWord)) {
				int magCount = magazineMap.get(noteWord).intValue();
				int noteCount = noteMap.get(noteWord).intValue();

				if (!(magCount >= noteCount)) {
					allMatched = false;
				}
			} else {
				allMatched = false;
			}
		}

		return allMatched;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RansomHashMap s = new RansomHashMap(scanner.nextLine(), m, scanner.nextLine(), n);
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}