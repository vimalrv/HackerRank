package com.helpermonkey.algorithms;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciNew {

	public static String findNewFibonacci(int t1, int t2, int tn) {
		BigDecimal fi = new BigDecimal(""+t1);
		BigDecimal fi1 = new BigDecimal(""+t2);
		BigDecimal fin = new BigDecimal(""+0);
		BigDecimal fi2 = new BigDecimal(""+0);

		for (int i = 3; i <= tn; i++) {
			//fin = fi + (fi1 * fi1);
			
			fi2 = fi1.multiply(fi1);
			fin = fi.add(fi2);
			
			fi = fi1;
			fi1 = fin;
		}
		
		return fin.toPlainString();
		
		//String strArr = str.substring(0, str.indexOf('.'));
	}

	public static boolean validateAlternatingSequence(char[] newSeq, int length) {
		for (int i = 0; i < length - 1; i++) {
			if (newSeq[i] == newSeq[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int tn = in.nextInt();

		System.out.println(findNewFibonacci(t1, t2, tn));
	}
}