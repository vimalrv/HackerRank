package stubs;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_S3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		//int m = in.nextInt();
		//int p = in.nextInt();
		
		String[] types = new String[n];
		for (int i = 0; i < n; i++) {
			types[i] = in.next();
		}
		
		/*** ArrayList input
		  
		ArrayList<Integer> alist = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			alist.add(in.nextInt());
		}
		
		*** TreeSet input
		// remove duplicates while adding itself and it also sorts it in natural order.
		TreeSet<Integer> t = new TreeSet<Integer>();
		for (int types_i = 0; types_i < n; types_i++) {
			int score = in.nextInt();

			if (!t.contains(score)) {
				t.add(score);
			}
		}

		// convert tree to list, so you can use index based fetch
		ArrayList<Integer> scoreList = new ArrayList<Integer>(t);
		 
		****/
				

		// comparator stub for use, great one to compare large numbers, convert them to
		// string and no memory overruns...
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String i, String j) {
				int n = i.length();
				int m = j.length();
				if (n == m)
					return (i.compareTo(j));

				if (n < m) {
					return -1;
				} else if (n > m) {
					return 1;
				}
				return 0;
			}
		};

		Arrays.sort(types, c);

		for (int i = 0; i < n; i++) {
			System.out.println(types[i]);
		}

	}
	
	/*** SIMPLE INT ARRAY ***/
//	static int divisibleSumPairs(int n, int k, int[] ar, int[] br) {
//		for (int i = 0; i < n; i++) {
//			System.out.println(ar[i]);
//		}
//		for (int i = 0; i < k; i++) {
//			System.out.println(br[i]);
//		}
//		return 0;
//	}
	
	/*** ARRAY LIST ***/
//	static int solveProblem(int n, ArrayList<Integer> alist, int k) {
//
//		int cntr = 0;
//		for (int i = 0; i < alist.size(); i++) {
//			for (int j = 0; j < alist.size(); j++) {
//			}
//		}
//
//		return cntr;
//	}
	
}