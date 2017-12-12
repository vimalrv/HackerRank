package com.helpermonkey.solved;
import java.util.Scanner;

public class Solution_DrawingBook {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();

		// System.err.println(Arrays.toString(types));

		int pagesToTurn = 0;

		boolean fromFront = false;
		// if(n%2 == 0) {
		if (p <= n / 2) {
			fromFront = true;
		} else {
			fromFront = false;
		}
		// }

		if (fromFront) {
			if (p != 1) {
				// go from front
				for (int i = 2; i <= (n / 2); i = i + 2) {
					if (i <= p) {
						pagesToTurn++;
					}
				}
			}
		} else {
			// go from back

			for (int i = n - 2; i > (n / 2); i = i - 2) {
				if (((n % 2 == 0) && (p < n))) {
					if (i >= p - 1) {
						pagesToTurn++;
					}
				} else if ((n % 2 > 0) && (p < n-1)) {
					if (i > (p - 1)) {
						pagesToTurn++;
					}
				}
			}

		}

		System.out.println(pagesToTurn);
	}
}

/*******     easier - simpler solution *******/
//public class Solution {
//    static int solve(int n, int p){
//        int halfway = n / 2;
//        int turns = 0;
//        if (p > halfway) { 
//            // turn from back
//            int rev = n - p;
//            if (rev > 1) {
//                turns = rev/2;
//            }
//        } else {
//            // turn from front
//            if (p > 1) {
//                turns = p/2;
//            }
//        }
//        return turns;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int p = in.nextInt();
//        int result = solve(n, p);
//        System.out.println(result);
//    }
//}