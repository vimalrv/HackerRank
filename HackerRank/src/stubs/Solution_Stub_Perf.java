package stubs;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_Stub_Perf {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

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

		int aliceScore = 0;
		int aliceCurRank = scoreList.size() + 1;

		boolean gotRank = false;
		int currPtr = 0;

		int m = in.nextInt();
		int[] aliceRanks = new int[m];
		for (int i = 0; i < m; i++) {
			gotRank = false;
			aliceScore = in.nextInt();

			/******
			 * LARGE LISTS - look at the pointer currPtr, this makes sure that list is
			 * always traversed from last point instead of resetting to 0 and going again
			 * and again through the list, this helps to avoid multiple loops - large lists
			 *****/

			for (int k = currPtr; k < scoreList.size(); k++) {
				if (aliceScore < scoreList.get(k)) {
					aliceRanks[i] = aliceCurRank;
					gotRank = true;
					break;
				}
				aliceCurRank--;
				currPtr = k + 1;
			}

			if (!gotRank && aliceScore >= scoreList.get(0))
				aliceRanks[i] = 1;
		}
		for (int i = 0; i < aliceRanks.length; i++) {
			System.out.println(aliceRanks[i]);
		}

	}
}
