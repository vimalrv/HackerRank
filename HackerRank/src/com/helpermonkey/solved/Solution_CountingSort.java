package com.helpermonkey.solved;
import java.lang.*;
import java.util.*;

public class Solution_CountingSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputSize = in.nextInt();

		int[] inputArray = new int[inputSize];
		for (int i = 0; i < inputSize; i++)
			inputArray[i] = in.nextInt();

		Map<Integer, Integer> countList = new HashMap<Integer, Integer>(inputSize);
		for (int i = 0; i < inputSize; i++) {
			if (countList.containsKey(inputArray[i]))
				countList.put(inputArray[i], countList.get(inputArray[i]) + 1);
			else
				countList.put(inputArray[i], 1);
		}

		Integer[] countIntegers = new Integer[100];
		for (int i = 0; i < 100; i++)
			if (countList.containsKey(i))
				countIntegers[i] = (Integer) countList.get(i);
			else
				countIntegers[i] = 0;

		printResult(countIntegers);
	}

	public static void printResult(Integer[] countIntegers) {
		for (int i = 0; i < countIntegers.length; i++) {
			if (countIntegers[i] != 0) {
				if (countIntegers[i] == 1) {
					System.out.print(i + " ");
				} else {
					for (int j = 0; j < countIntegers[i]; j++) {
						System.out.print(i + " ");
					}
				}
			}
		}
	}
}
