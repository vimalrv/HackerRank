package com.helpermonkey.algoeasy.strings;

import java.util.Scanner;

public class Staircase {
    
    public static void printStircase(int siz){
       for(int i=0; i<siz; i++){
    	   	for(int c=siz;c>=0;c--) {
    	   		if(i>=c) {
    	   			System.out.print("#");
    	   		}else {
    	   			if(!(c==siz))
    	   				System.out.print(" ");
    	   		}
    	   	}
    	   	System.out.println("");
       }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       
        printStircase(n);
    }
}