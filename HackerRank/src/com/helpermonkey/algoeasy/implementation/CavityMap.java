package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class CavityMap {

	public static char[][] findCavity(char[][] cells) {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (i != 0 && i != cells.length - 1 && j != 0 && j != cells.length - 1) {
					char value = cells[i][j];
					if ((cells[i][j - 1] < value) && (cells[i][j + 1] < value) && (cells[i - 1][j] < value) && (cells[i
							+ 1][j] < value)) {
						cells[i][j] = 'X';
					}
				}
			}
		}

		for (int i = 0; i < cells.length; i++) {
			System.out.println(new String(cells[i]));
		}

		return cells;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[][] grid = new char[n][n];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			grid[grid_i] = in.next().toCharArray();
		}

		findCavity(grid);

		in.close();
	}
}