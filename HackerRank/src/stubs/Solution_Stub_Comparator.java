package stubs;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_Stub_Comparator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] types = new String[n];
		for (int types_i = 0; types_i < n; types_i++) {
			types[types_i] = in.next();
		}

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
}