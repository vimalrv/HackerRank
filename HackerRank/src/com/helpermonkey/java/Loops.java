package com.helpermonkey.java;

import java.util.Scanner;

class Loop{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int sum=a+(1*b);
            for(int j=1; j<n; j++) {
            		System.out.print(sum + " ");
            		sum += new Double(Math.pow(2, j)).intValue() * b;
            }
            System.out.println(sum);
            System.out.println("short:" + Math.pow(2, 15));
        }
        in.close();
    }
}
