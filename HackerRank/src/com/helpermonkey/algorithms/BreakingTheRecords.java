package com.helpermonkey.algorithms;

import java.util.Scanner;

public class BreakingTheRecords {

    static int[] getRecord(int[] s){
    		int minCntr=0;
    		int maxCntr=0;
    		int min = s[0];
    		int max = s[0];
        for (int i = 0; i < s.length; i++) {
        		if(s[i]<min) {
        			minCntr++;
        			min = s[i];
        		}
        		if(s[i]>max) {
        			maxCntr++;
        			max = s[i];
        		}
		}
        
        return new int[]{maxCntr, minCntr};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}