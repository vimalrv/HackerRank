package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class HackerRankPsvm {

    static long aVeryBigSum(int n, long[] ar) {
        // Complete this function
    		return 1L;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }
}
