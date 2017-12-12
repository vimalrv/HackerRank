package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class JumpingOnTheClouds {
	
	public static int findEnergyAfterJumping(int jumpDistance, int[] clouds) {
		
		int totalClouds = clouds.length;
		int energy = 100;
		
		if(jumpDistance > totalClouds) {
			return energy;
		}
		
		int curPosition = jumpDistance;
		while(curPosition < totalClouds) {
			if(clouds[curPosition] == 1) {
				energy = energy - 1 - 2;
			}else {
				energy = energy - 1;
			}
			curPosition += jumpDistance;
		}
		
		if(clouds[0] == 1) {
			energy = energy - 1 - 2;
		}else {
			energy = energy - 1;
		}
		
		return energy;
		
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int clouds[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
        	clouds[c_i] = in.nextInt();
        }
        
        System.out.println(findEnergyAfterJumping(k, clouds));
        
    }
}