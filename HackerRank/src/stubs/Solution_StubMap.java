package stubs;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_StubMap {

	static int divisibleSumPairs(int n, int k, int[] ar, int[] br) {
		// Complete this function
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] ar = new int[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		
		int[] br = new int[n];
		for (int ar_i = 0; ar_i < k; ar_i++) {
			br[ar_i] = in.nextInt();
		}
		
		int result = divisibleSumPairs(n, k, ar, br);
		
		System.out.println(result);
	}
}
