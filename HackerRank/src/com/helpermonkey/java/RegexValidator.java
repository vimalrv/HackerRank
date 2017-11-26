package com.helpermonkey.java;

import java.util.Scanner;
import java.util.regex.Pattern;

class RegexValidator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// String a = scan.nextLine();
		// scan.close();
		//
		// try {
		// Pattern p = Pattern.compile(a);
		// System.out.println("Valid");
		// } catch (Exception ex) {
		// System.out.println("Invalid");
		// }

		while (scan.hasNext()) {
			String IP = scan.next();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
	}
}

class MyRegex {

	// ^ -------------# START OF STRING
	// (?=\d+\.\d+\.\d+\.\d+$) -------------# Lookahead, require this format:
	// number.number.number.number END OF STRING
	// (?: ----------# Start non-capture group (number 0-255 + optional dot)
	// (?: ------# Start non-capture group (number 0-255)
	// 25[0-5] --------# 250-255
	// | -----------# OR
	// 2[0-4][0-9] -----------# 200-249
	// | ----------# OR
	// 1[0-9]{2} ------------# 100-199
	// | -------------# OR
	// [1-9][0-9] -------------# 10-99
	// | -------------# OR
	// [0-9] ------------# 0-9
	// ) -----------# End non-capture group
	// \.? ----------# Optional dot (enforced in correct positions by lookahead)
	// ){4} ---------# End non-capture group (number + optional dot), repeat 4 times
	// $
	
	///\s(\w+\s)\1/, " $1"
	//"\\b(\\w+)(\\b\\W+\\b\\1\\b)*"; 

	// public static final String pattern = "[[0-255]{1,3}\\.{1}]{4}";
	public static final String pattern = "^(?=\\d+\\.\\d+\\.\\d+\\.\\d+$)(?:(?:25[0-5]|2[0-4][0-9]|[0-1]([0-9]{2})|[0-9][0-9]|[0-9])\\.?){4}$";
}
