import java.util.HashMap;
import java.util.Map;

public class Solution_Q2 {

	static String[] findNumberOfCowsAndBulls(Map<String, String> userInput) {
		String[] result = new String[userInput.keySet().size()];
		int r = 0;
		for (String key : userInput.keySet()) {
			System.out.println("key="+key);
			String value = userInput.get(key);
			char[] aArr = key.toCharArray();
			char[] bArr = value.toCharArray();
			int bullCntr = 0;
			int cowCntr = 0;
			for (int i = 0; i < bArr.length; i++) {
				for (int j = 0; j < bArr.length; j++) {
					if (bArr[i] == aArr[j]) {
						if (i == j) {
							bullCntr++;
						} else {
							cowCntr++;
						}
					}
				}
			}
			result[r] = key + "=" + bullCntr + "-Bulls," + cowCntr + "-Cows";
			r++;
		}
		return result;
	}

	public static void main(String[] args) {
		HashMap<String, String> inMap = new HashMap<String, String>();
		inMap.put("1234", "4217");
		inMap.put("1235", "5321");
		inMap.put("5678", "5697");
		inMap.put("0321", "3901");

		String[] result = findNumberOfCowsAndBulls(inMap);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}