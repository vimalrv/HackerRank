package com.helpermonkey.java;

import java.util.HashMap;
import java.util.Scanner;

class Anagrams {

	static boolean isAnagram(String a, String b) {
		// if (a == null || b == null || a.isEmpty() || b.isEmpty())
		// return false;

		char[] aArr = a.toUpperCase().toCharArray();
		char[] bArr = b.toUpperCase().toCharArray();

		int length = aArr.length;
		HashMap<Character, Integer> cntr = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			char key = aArr[i];
			int value = 0;
			if (cntr.containsKey(key))
				value = cntr.get(key);

			if (value < 1) {
				cntr.put(key, 1);
			} else {
				cntr.put(key, value + 1);
			}
		}

		length = bArr.length;
		for (int i = 0; i < length; i++) {
			char key = bArr[i];
			int value = 0;
			if (cntr.containsKey(key))
				value = cntr.get(key);

			if (value < 1) {
				return false;
			} else {
				int newValue = value - 1;
				if (newValue < 0) {
					return false;
				}
				if(newValue == 0) {
					cntr.remove(key);
				}else {
					cntr.put(key, newValue);
				}
			}
		}
		
		if(cntr.size() > 0)
			return false;

		return true;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
