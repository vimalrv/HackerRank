package stubs;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_StubList {

	static int solveProblem(int n, ArrayList<Integer> alist, int k) {

		int cntr = 0;
		for (int i = 0; i < alist.size(); i++) {
			for (int j = 0; j < alist.size(); j++) {
			}
		}

		return cntr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		ArrayList<Integer> alist = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			alist.add(in.nextInt());
		}

		int result = solveProblem(n, alist, k);

		System.out.println(result);
	}
}
