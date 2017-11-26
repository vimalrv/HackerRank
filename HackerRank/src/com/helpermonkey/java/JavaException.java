package com.helpermonkey.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaException {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			int a = in.nextInt();
			int b = in.nextInt();

			System.out.println(a / b);
		} catch (InputMismatchException e) {
			System.out.println("java.util.InputMismatchException");
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
