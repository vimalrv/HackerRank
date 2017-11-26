package com.helpermonkey.algorithms;

import java.util.Scanner;

public class PlusMinus {
    
    public static double[] findPlusMinus(int siz, long[] ar){
       double p = 0;
       double n = 0;
       double z = 0;
       
       for(int i=0; i<siz; i++){
    	   	   if(ar[i] > 0) {
    	   		   p+=1;
    	   	   }else if(ar[i] < 0) {
    	   		   n+=1;
    	   	   }else {
    	   		   z+=1;
    	   	   }
        }
       
       double[] result = new double[3];
       result[0] = (p/siz);
       result[1] = (n/siz);
       result[2] = (z/siz);
       
       
        return  result;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        
        for(int ar_r=0; ar_r<n; ar_r++){
                ar[ar_r] = in.nextLong();
        }
        
        double[] result = findPlusMinus(n, ar);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}