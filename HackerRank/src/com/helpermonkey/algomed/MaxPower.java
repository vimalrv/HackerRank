package com.helpermonkey.algomed;

public class MaxPower {

	static int getMinOperations(int[] kValues) {
		int length = kValues.length;
		int[] nKValues = kValues.clone();
		java.util.Arrays.sort(nKValues);
		
		//System.out.println(Arrays.toString(nKValues));
		
		int bigPower = nKValues[length - 1];
		if(length == 1){
			return bigPower;
		}
		
		int secondBigPower = nKValues[length - 2];
		if(length == 2){
			if(bigPower > secondBigPower){
				return bigPower;
			}else{
				return secondBigPower;
			}
		}
		
		int thirdBigPower = -999999999;
		int fourthBigPower = -999999999;
		
		thirdBigPower = nKValues[length - 3];
		if(length >= 4){
			fourthBigPower = nKValues[length - 4];
		}
		
		int maxPower = bigPower;
		int tmp = bigPower;

		for (int i = 0; i < length; i++) {
			if (kValues[i] == bigPower) {
				if (isNotNextToEachOther(kValues, i, secondBigPower)) {
					tmp = bigPower + secondBigPower;
					if(tmp >= maxPower){
						maxPower = tmp;
					}
					break;
				}
				if (isNotNextToEachOther(kValues, i, thirdBigPower)) {
					tmp = bigPower + thirdBigPower;
					if(tmp >= maxPower){
						maxPower = tmp;
					}
					break;
				}
				if(length == 3){
					maxPower = bigPower;
					break;
				}
				
				if (isNotNextToEachOther(kValues, i, fourthBigPower)) {
					tmp = bigPower + fourthBigPower;
					if(tmp >= maxPower){
						maxPower = tmp;
					}
					break;
				}
			}
		}
		return maxPower;
	}

	private static boolean isNotNextToEachOther(int[] kValues, int i, int powerValue) {

		int left = kValues[i - 1];
		int right = 0;
		if (i < kValues.length - 1) {
			right = kValues[i + 1];
		}

		if (powerValue != left && powerValue != right) {
			return true;
		}

		return false;
	}

	public static void main(String[] args)  {
		java.util.Scanner in = new java.util.Scanner(System.in);

		int kValues_size = 0;
		kValues_size = Integer.parseInt(in.nextLine().trim());

		int[] kValues = new int[kValues_size];
		for (int i = 0; i < kValues_size; i++) {
			int kValues_item;
			if(in.hasNext()){
				kValues_item = in.nextInt();
				kValues[i] = kValues_item;
			}
		}

		System.out.println(getMinOperations(kValues));
	}
}
