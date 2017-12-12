package com.helpermonkey.algomed;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Contacts {

	public static ArrayList<String> contacts = new ArrayList<String>();

	public static void add(String contact) {
		contacts.add(contact);
	}

	public static void find(String findMe) {
		int counter = 0;
		for (Iterator<String> iterator = contacts.iterator(); iterator.hasNext();) {
			String searchMe = iterator.next();
			if (searchMe.startsWith(findMe)) {
				counter++;
			}
		}
		System.out.println(counter);
	}

	public static void main(String[] args) throws Exception{
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileInputStream(new File("/Users/vimalsekar/3_Projects/java/HackerRank/contact-input-1.txt")));
		int n = in.nextInt();

		for (int a0 = 0; a0 < n; a0++) {
			if(!in.hasNext())
				break;
			String op = in.next();
			String contact = in.next();
			if ("add".equals(op)) {
				add(contact);
			} else {
				find(contact);
			}
		}
		in.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("total time="+(endTime-startTime));
	}
}
