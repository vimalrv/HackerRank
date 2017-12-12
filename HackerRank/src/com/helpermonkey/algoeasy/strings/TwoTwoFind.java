package com.helpermonkey.algoeasy.strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoTwoFind {

	static final int ALPHABET_SIZE = 26;
	Node[] nodes;
	int nodeCount;

	public class Node {
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

	public TwoTwoFind(int maxNodes) {
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
			int c = ch - 'a';
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
		int c = ch - 'a';
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
			this.addString(pattern);

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
			
			String patternStr = in.next();
			TwoTwoFind ahoCorasick = new TwoTwoFind(1000);
			ahoCorasick.addString(patternStr);

			int node = 0;
			for (char ch : mainStr.toCharArray()) {
				node = ahoCorasick.transition(node, ch);
			}
			if (ahoCorasick.nodes[node].leaf) {
				 System.out.println("A '" + patternStr + "' string is substring of "
		                    + mainStr + " string.");
			}


			// load the string into the trie here
			//TwoTwoFind ahoCorasick = new TwoTwoFind(10000);
			// ahoCorasick.addString(mainStr);

			// System.out.println("Str received is:" + s);
			//System.out.println(ahoCorasick.findPowersOfTwoUsingTrie(mainStr, powerValues));
			//System.out.println(ahoCorasick.findPowersOfTwoUsingTrie(mainStr, powerValues));
		}

		in.close();
	}
}