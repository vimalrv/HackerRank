package com.helpermonkey.solved;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_Hurdle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        ArrayList<Integer> height = new ArrayList<Integer>();
        for(int types_i=0; types_i < n; types_i++){
            height.add(in.nextInt());
        }
        
        int maxHeight = Collections.max(height);
        
        int drinkRequired = maxHeight - k;
        if(drinkRequired < 0) {
        		drinkRequired = 0;
        }
        
        System.out.println(drinkRequired);
    }
}