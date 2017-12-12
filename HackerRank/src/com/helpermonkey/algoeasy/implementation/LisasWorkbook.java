package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class LisasWorkbook {

	public static int findMaxSpecialProblems(int problemsPerPage, int[] problemsInChapter) {
		int specialProblems = 0;
		int pageNo = 0;

		for (int i = 0; i < problemsInChapter.length; i++) {
			int chapterProblems = problemsInChapter[i];
			int curProblem = 1;

			boolean loop = true;
			while (loop) {
				pageNo += 1;
				for (int j = 0; j < problemsPerPage; j++) {
					if (curProblem == pageNo) {
						specialProblems += 1;
					}
					curProblem += 1;
					if (curProblem > chapterProblems) {
						loop = false;
						break;
					}
				}
			}
		}
		
//	    for(int i=0 ; i<n ; i++){
//            //System.out.println("x:"+x);
//            //System.out.print("|||j:"+j);
//            x = x+((j-2)/k)+1;
//            //System.out.println("check x:"+x);
//           // if((j != 0)&&(j%k == 0))
//             //   x--;
//        for(j=1 ; j<=m[i] ; j++){
//            y = x+(j-1)/k;
//            if(j==y)
//                count++;
//        }
//    }
//    System.out.println(count);

		return specialProblems;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}

		System.out.println(findMaxSpecialProblems(k, c));

		in.close();
	}
}