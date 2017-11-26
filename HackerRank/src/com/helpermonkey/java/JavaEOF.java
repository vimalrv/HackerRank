package com.helpermonkey.java;

import java.util.ArrayList;
import java.util.Scanner;

class JavaEOF {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		ArrayList<String> strList = new ArrayList<String>();
		while(sc.hasNextLine()) {
			strList.add(sc.nextLine());
		}
		
		int i=0;
		for(String str : strList) {
			System.out.println(++i + " " + str);
		}
	}
}
