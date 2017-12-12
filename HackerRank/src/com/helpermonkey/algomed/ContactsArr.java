package com.helpermonkey.algomed;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ContactsArr {
	public static char[][] contacts = null;
	public static int addCntr = 0;

	public static void add(char[] contact) {
		contacts[addCntr] = contact;
		addCntr++;
	}

	public static void find(char[] findMe) {
		int findCntr = 0;

		for (int i = 0; i < addCntr; i++) {
			boolean startsWith = true;
			char[] searchMe = contacts[i];

			for (int k = 0; k < findMe.length; k++) {
				if (findMe.length > searchMe.length) {
					startsWith = false;
					break;
				}
				if (searchMe[k] != findMe[k]) {
					startsWith = false;
					break;
				}
			}

			if (startsWith)
				findCntr++;
			// if (searchMe.startsWith(findMe)) {
		}
		System.out.println(findCntr);
	}

	public static final char[] ADD = { 'a', 'd', 'd' };

	public static void main(String[] args) throws Exception{
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(
				new FileInputStream(new File("/Users/vimalsekar/3_Projects/java/HackerRank/contact-input-1.txt")));
		int n = in.nextInt();
		contacts = new char[n][21];

		for (int a0 = 0; a0 < n; a0++) {
			if (!in.hasNext())
				break;
			char[] op = in.next().toCharArray();
			char[] contact = in.next().toCharArray();

			if ((ADD[0] == op[0]) && (ADD[1] == op[1]) && (ADD[2] == op[2])) {
				add(contact);
			} else {
				find(contact);
			}
		}
		
		in.close();

		long endTime = System.currentTimeMillis();
		System.out.println("total time=" + (endTime - startTime));
	}
}
