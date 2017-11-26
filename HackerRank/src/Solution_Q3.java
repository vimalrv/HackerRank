
import java.util.LinkedHashMap;

public class Solution_Q3 {

	public static int compareValues(String i, String j) {

		int intValuei = 0;
		try {
			intValuei = new Integer(i).intValue();
		} catch (Exception ex) {
			// i is an alphabet
			intValuei = (int) i.charAt(0);
		}

		int intValuej = 0;
		try {
			intValuej = new Integer(j).intValue();
		} catch (Exception ex) {
			// i is an alphabet
			intValuej = (int) j.charAt(0);
		}
		if (intValuei > intValuej) {
			return 1;
		} else if (intValuei < intValuej) {
			return -1;
		}
		return 0;
	}

	public static LinkedHashMap<String, String> codeTheSolution(LinkedHashMap<String, String> inMap) {
		int length = inMap.keySet().size();
		
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

		for (String key : inMap.keySet()) {
			boolean pointerStarted = false;
			int cntr = 0;

			for (String key2 : inMap.keySet()) {
				if (key.equals(key2) || pointerStarted) {
					pointerStarted = true;
					int compareVal = compareValues(inMap.get(key), inMap.get(key2));
					if (compareVal > 0) {
						cntr++;
					}
				}
			}
			result.put(key, "" + cntr);
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		result.put("0", "12");
		result.put("5", "1");
		result.put("2", "0");
		result.put("3", "a");
		result.put("7", "11");
		result.put("4", "A");
		result.put("1", "3");

		System.out.println(codeTheSolution(result));
	}


/*** LinkedHashMap does return keys and values in the same order it maintains ORDER GURANTEED.
 * Different implementation using arrays,
 * 
		System.out.println("value="+inputLinkHashMap.keySet());
		System.out.println("value="+inputLinkHashMap.values());

//		String[] keys = new String[inputLinkHashMap.size()];
//		keys = inputLinkHashMap.keySet().toArray(keys);
//
//		String[] values = new String[inputLinkHashMap.size()];
//		values = inputLinkHashMap.values().toArray(values);
//
//		for (int i = 0; i < keys.length; i++) {
//			int count = 0;
//			for (int j = i + 1; j < values.length; j++) {
//				int compareVal = compareValues(values[i], values[j]);
//				if (compareVal > 0) {
//					count++;
//				}
//			}
//			result.put(keys[i], "" + count);
//		}
	***/

}
