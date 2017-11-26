package com.helpermonkey.solved;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_Great_Solved {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
        }
        
        Arrays.sort(types);
        
        int currentBirdCount = 1;
        int highestCount = 0;
        int currentBird = types[0];
        int mostFrequent = types[0];
        
        for (int i = 0; i < n - 1; i++){
            currentBird = types[i];
            if (types[i] == types[i + 1]){
                currentBirdCount++;
                if (currentBirdCount > highestCount){
                    highestCount = currentBirdCount;
                    mostFrequent = currentBird;
                }
            } else {
                currentBirdCount = 1;
            }
        }
        System.out.println(mostFrequent);
    }
}