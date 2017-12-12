package com.helpermonkey.algoeasy.strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DesignerPDFViewer {

	// public static String createSubString(char[] baseCharArr, int startIndex, int noOfChars) {
	// StringBuilder sb = new StringBuilder();
	// int endIndex = startIndex + noOfChars;
	// for (int i = startIndex; i < endIndex; i++) {
	// sb.append(baseCharArr[i]);
	// }
	//
	// return sb.toString();
	// }

	// public static boolean IsPowerOfTwo(String s) {
	// try {
	// long n = Long.parseLong(s);
	//
	// return (n != 0) && ((n & (n - 1)) == 0);
	// } catch (Exception ex) {
	// // if the number is too large and we are getting an exception then
	// // let us use BigInteger, in all other cases use the primitive long
	// // this is to ensure we get speed of execution.
	// }
	//
	// /***
	// * e.g. boolean b = IsPowerOfTwo(4)
	// * return (4 != 0) && ((4 & (4-1)) == 0);
	// * 1st condition is true
	// * 2nd condition:
	// * ((4 & (4-1)) == 0)
	// * ((4 & 3) == 0)
	// * 100 - 4
	// * 011 - 3
	// * ----
	// * 000 & bitwise-and operation
	// * 2nd condition is also true
	// * return true && (0 == 0);
	// * return true && true; is equal to true
	// ***/
	//
	// BigInteger bInt = new BigInteger(s);
	// BigInteger bIntMinusOne = bInt.subtract(new BigInteger("1"));
	//
	// return ((bInt.and(bIntMinusOne)).intValue() == 0);
	// }

	// for (int i = 1; i <= 300; i++) {
	// BigInteger bigInt = new BigInteger("2");
	// BigInteger value = bigInt.pow(i);
	//
	// String findStr = value.toString();
	//
	// //double powerValue = Math.pow(2, i);
	//
	// // proper string representation of the double value, not the string with E power 7 kind of representation
	// //String findStr = String.format("%.0f", new Double(powerValue));
	//
	// //System.out.println("i=" + i + ",find string=" + findStr + ", powerValue=" + powerValue);
	//
	// // regular loop based method to find sub string occurance in a string
	// int lastIndex = 0;
	//
	// while (lastIndex != -1) {
	// lastIndex = str.indexOf(findStr, lastIndex);
	//
	// if (lastIndex != -1) {
	// count++;
	// lastIndex += findStr.length();
	// }
	// }
	// System.out.println(count);
	// }

	// string split based one, even more concise but not sure about cpu cycles.
	// String str = "helloslkhellodjladfjhello";
	// String findStr = "hello";
	// System.out.println(str.split(findStr, -1).length-1);

	// proper string representation of the double value, not the string with E poer 7 kind of representation
	// String powerValStr = String.format("%.0f", new Double(powerValue));

	public static int findPowersOfTwo(String str, String[] powerValues) {
		// double[] powersOfTwo = new double[800];
		int count = 0;

		// find all 800 powers of 2.
		for (int i = 0; i <= 800; i++) {
			String powerValStr = powerValues[i];

			// if the power value is greater size, no point looping thru further
			if (powerValStr.length() > str.length()) {
				break;
			}

			// regex based method to find sub string occurance in a string
			Pattern p = Pattern.compile(powerValStr);
			Matcher m = p.matcher(str);

			while (m.find()) {
				count += 1;
			}
			// System.out.println("count of power value:" + powerValStr + ", in str is:" + count);
		}

		return count;
	}

	static final int ALPHABET_SIZE = 26;
	Node[] nodes;
	int nodeCount;

	public static class Node {
		int parent;
		char charFromParent;
		int suffLink = -1;
		int[] children = new int[ALPHABET_SIZE];
		int[] transitions = new int[ALPHABET_SIZE];
		boolean leaf;

		{
			Arrays.fill(children, -1);
			Arrays.fill(transitions, -1);
		}
	}

	public DesignerPDFViewer(int maxNodes) {
		nodes = new Node[maxNodes];
		// create root
		nodes[0] = new Node();
		nodes[0].suffLink = 0;
		nodes[0].parent = -1;
		nodeCount = 1;
	}

	public void addString(String s) {
		int cur = 0;
		for (char ch : s.toCharArray()) {
			int c = ch - '0';
			if (nodes[cur].children[c] == -1) {
				nodes[nodeCount] = new Node();
				nodes[nodeCount].parent = cur;
				nodes[nodeCount].charFromParent = ch;
				nodes[cur].children[c] = nodeCount++;
			}
			cur = nodes[cur].children[c];
		}
		nodes[cur].leaf = true;
	}

	public int suffLink(int nodeIndex) {
		Node node = nodes[nodeIndex];
		if (node.suffLink == -1) node.suffLink = node.parent == 0 ? 0
				: transition(suffLink(node.parent), node.charFromParent);
		return node.suffLink;
	}

	public int transition(int nodeIndex, char ch) {
		int c = ch - '0';
		Node node = nodes[nodeIndex];
		if (node.transitions[c] == -1) node.transitions[c] = node.children[c] != -1 ? node.children[c]
				: (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
		return node.transitions[c];
	}

	public int findPowersOfTwoUsingTrie(String main, String[] powerValues) {
		int count = 0;

		// find all 800 powers of 2.
		for (int i = 0; i <= 800; i++) {
			String pattern = powerValues[i];

			int node = 0;
			for (char ch : main.toCharArray()) {
				node = this.transition(node, ch);
			}
			if (this.nodes[node].leaf) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();

		// create the string equivalent of all the power values until 2 ^ 800
		String[] powerValues = new String[801];
		for (int i = 0; i <= 800; i++) {
			BigInteger bigInt = new BigInteger("2");
			BigInteger value = bigInt.pow(i);
			powerValues[i] = value.toString();
		}

		for (int a0 = 0; a0 < noOfTestCases; a0++) {
			String mainStr = in.next();

			// load the string into the trie here
			TwoTwoFind ahoCorasick = new TwoTwoFind(1000);
			ahoCorasick.addString(mainStr);

			// System.out.println("Str received is:" + s);
			System.out.println(ahoCorasick.findPowersOfTwoUsingTrie(mainStr, powerValues));
		}

		in.close();
	}
}