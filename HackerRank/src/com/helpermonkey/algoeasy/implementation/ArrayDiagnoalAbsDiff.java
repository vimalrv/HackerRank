package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class ArrayDiagnoalAbsDiff {
    
    public static long findDiff(int n, long[][] ar){
       long l2RDiagSum = 0;
       long r2lDiagSum = 0;
       for(int ar_r=0; ar_r<n; ar_r++){
           l2RDiagSum += ar[ar_r][ar_r];
           r2lDiagSum += ar[ar_r][((n-1) - ar_r)];
        }
       
        return  Math.abs(l2RDiagSum - r2lDiagSum);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] ar = new long[n][n];
        
        for(int ar_r=0; ar_r<n; ar_r++){
            for(int ar_c = 0; ar_c < n; ar_c++){
                ar[ar_r][ar_c] = in.nextLong();
            }
        }
        
        long result = findDiff(n, ar);
        System.out.println(result);
    }
}