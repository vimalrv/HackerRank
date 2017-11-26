
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution_Q1 {

	static int[] getMinOperations(long[] kValues) {
		int operationCntr = 1;
		int length = kValues.length;
		int[] resultArr = new int[length];
		long result = 1;

		for (int i = 0; i < length; i++) {
			long value = kValues[i];

			if (value == 1) {
				resultArr[i] = operationCntr;
				break;
			}

			// if 2 or greater, do the multiplications first - 2 tables.
			do {
				result = result * 2;
				operationCntr++;
			} while (result < value);

			if (result == value) {
				resultArr[i] = operationCntr;
				operationCntr = 1;
				result = 1;
				break;
			}

			// if result has exceeded the value, reset back to one last value, then add
			result = result / 2;
			operationCntr--;

			// System.out.println("multiply=" + (operationCntr-1) + ":" + result);
			operationCntr += (value - result);

			resultArr[i] = operationCntr;
			operationCntr = 1;
			result = 1;
		}
		return resultArr;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		int[] res;
		int kValues_size = 0;
		kValues_size = Integer.parseInt(in.nextLine().trim());

		long[] kValues = new long[kValues_size];
		for (int i = 0; i < kValues_size; i++) {
			long kValues_item;
			kValues_item = Long.parseLong(in.nextLine().trim());
			kValues[i] = kValues_item;
		}

		res = getMinOperations(kValues);
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}

		bw.close();
	}
}
