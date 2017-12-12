package com.helpermonkey.algomed;

import java.util.ArrayList;

public class BalancedBrackets {

	public static final Character OPEN_CURLY_BRACKET = new Character('(');
	public static final Character OPEN_SQUARE_BRACKET = new Character('[');
	public static final Character OPEN_BRACES = new Character('{') ;
	public static final Character CLOSED_CURLY_BRACKET = new Character(')');
	public static final Character CLOSED_SQUARE_BRACKET = new Character(']');
	public static final Character CLOSED_BRACES = new Character('}');

	public static boolean isBalanced(String expression) {
		if (expression == null)
			return true;

		char[] brkChars = expression.toCharArray();

		ArrayList<Character> openBrk = new ArrayList<Character>();

		for (int i = 0; i < brkChars.length; i++) {
			if (OPEN_CURLY_BRACKET.equals(new Character(brkChars[i]))
					|| OPEN_SQUARE_BRACKET.equals(new Character(brkChars[i]))
					|| OPEN_BRACES.equals(new Character(brkChars[i]))) {
				openBrk.add(new Character(brkChars[i]));
			} else if (CLOSED_CURLY_BRACKET.equals(new Character(brkChars[i]))) {
				int index = openBrk.size() - 1;
				if(index < 0)
					return false;
				
				if (OPEN_CURLY_BRACKET.equals(openBrk.get(index))) {
					openBrk.remove(index);
				} else {
					// this is a non matched bracket, so it is NOT balances, so we can exit and say
					// NO
					return false;
				}
			} else if (CLOSED_SQUARE_BRACKET.equals(new Character(brkChars[i]))) {
				int index = openBrk.size() - 1;
				if(index < 0)
					return false;
				
				if (OPEN_SQUARE_BRACKET.equals(openBrk.get(index))) {
					openBrk.remove(index);
				} else {
					// this is a non matched bracket, so it is NOT balances, so we can exit and say
					// NO
					return false;
				}
			} else if (CLOSED_BRACES.equals(new Character(brkChars[i]))) {
				int index = openBrk.size() - 1;
				if(index < 0)
					return false;
				
				if (OPEN_BRACES.equals(openBrk.get(index))) {
					openBrk.remove(index);
				} else {
					// this is a non matched bracket, so it is NOT balances, so we can exit and say
					// NO
					return false;
				}
			} else {
				// this is a non matched bracket, so it is NOT balances, so we can exit and say
				// NO
				return false;
			}
		}
		if(openBrk.size() < 1) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		int t = 3;
		String str1 = "{[()]}";
		String str2 = "{[(])}";
		String str3 = "{{[[(())]]}}";
		String str4 = "{{[[((){}[({()})])]]}}";

		System.out.println((isBalanced(str1)) ? "YES" : "NO");
		System.out.println((isBalanced(str2)) ? "YES" : "NO");
		System.out.println((isBalanced(str3)) ? "YES" : "NO");
		System.out.println((isBalanced(str4)) ? "YES" : "NO");
	}
}
