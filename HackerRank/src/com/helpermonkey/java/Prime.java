package com.helpermonkey.java;

import java.math.BigInteger;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		in.close();

		if(n.compareTo(new BigInteger("1")) == 0) {
			System.out.println("not prime");	
		}else if (n.isProbablePrime(100)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}

}
