package com.helpermonkey.algoeasy.strings;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StringMatcherAhoCorasick {

	// protected String[] filterPatterns(String[] patterns) {
	// Set<String> filter = new HashSet<>(Arrays.asList(patterns));
	// return filter.toArray(new String[filter.size()]);
	// }

	/**
	 * This class represents a match.
	 */
	public static final class MatchingResult {

		/**
		 * The index of the pattern being matched.
		 */
		public final int inputPatternIndex;

		/**
		 * The index of the last character in a pattern indexed by
		 * {@code inputPatternIndex}.
		 */
		public final int lastCharIndex;

		public MatchingResult(int patternIndex, int concludingIndex) {
			this.inputPatternIndex = patternIndex;
			this.lastCharIndex = concludingIndex;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}

			if (!getClass().equals(o.getClass())) {
				return false;
			}

			MatchingResult arg = (MatchingResult) o;

			return inputPatternIndex == arg.inputPatternIndex && lastCharIndex == arg.lastCharIndex;
		}

		@Override
		public int hashCode() {
			int hash = 5;
			hash = 41 * hash + this.inputPatternIndex;
			hash = 41 * hash + this.lastCharIndex;
			return hash;
		}

		public String toString() {
			return "(inputPatternIndex = " + inputPatternIndex + ", lastCharIndex = " + lastCharIndex + ")";
		}
	}

	public List<MatchingResult> match(Automaton data, String text) {

		// this is to make the search patterns as unique...
		// patterns = filterPatterns(patterns);

		TrieNode v = data.root;
		int n = text.length();
		List<MatchingResult> resultList = new ArrayList<>();

		for (int j = 0; j < n; ++j) {
			while (v.getChild(text.charAt(j)) == null) {
				v = data.fail.get(v);
			}

			v = v.getChild(text.charAt(j));

			for (Integer i : data.patterns.get(v)) {
				resultList.add(new MatchingResult(i, j));
			}
		}

		return resultList;
	}

	private static final class TrieNode {

		private final Map<Character, TrieNode> children = new HashMap<>();

		void setChild(char character, TrieNode child) {
			children.put(character, child);
		}

		TrieNode getChild(char character) {
			return children.get(character);
		}
	}

	private Automaton constructACAutomaton(String[] patterns) {
		Automaton ret = new Automaton();
		constructTrie(ret, patterns);
		computeFailureFunction(ret);
		return ret;
	}

	private void constructTrie(Automaton automaton, String[] patterns) {
		TrieNode root = new TrieNode();
		int k = patterns.length;

		for (int i = 0; i < k; ++i) {
			TrieNode tNode = root;
			int j = 0;
			int patternLength = patterns[i].length();

			while (j < patternLength && tNode.getChild(patterns[i].charAt(j)) != null) {
				tNode = tNode.getChild(patterns[i].charAt(j));
				++j;
			}

			while (j < patternLength) {
				TrieNode u = new TrieNode();
				tNode.setChild(patterns[i].charAt(j), u);
				tNode = u;
				++j;
			}

			List<Integer> list = new ArrayList<>();
			list.add(i);
			automaton.patterns.put(tNode, list);
		}

		automaton.patterns.put(root, new ArrayList<>());
		automaton.root = root;
	}

	private void computeFailureFunction(Automaton automaton) {
		TrieNode fallbackNode = new TrieNode();

		for (char c = '0'; c <= '9'; ++c) {
			fallbackNode.setChild(c, automaton.root);
		}

		automaton.fail.put(automaton.root, fallbackNode);
		Deque<TrieNode> queue = new ArrayDeque<>();
		queue.addLast(automaton.root);

		while (!queue.isEmpty()) {
			TrieNode u = queue.removeFirst();

			for (char c = '0'; c <= '9'; ++c) {
				if (u.getChild(c) == null) {
					continue;
				}

				TrieNode v = u.getChild(c);
				TrieNode w = automaton.fail.get(u);

				while (w.getChild(c) == null) {
					w = automaton.fail.get(w);
				}

				automaton.fail.put(v, w.getChild(c));

				List<Integer> list = automaton.patterns.get(automaton.fail.get(v));

				if (automaton.patterns.get(v) == null) {
					automaton.patterns.put(v, list);
				} else {
					automaton.patterns.get(v).addAll(list);
				}

				queue.addLast(v);
			}
		}

		automaton.patterns.put(automaton.root, new ArrayList<>());
	}

	private static final class Automaton {
		TrieNode root;
		Map<TrieNode, TrieNode> fail = new HashMap<>();
		Map<TrieNode, List<Integer>> patterns = new HashMap<>();
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

		StringMatcherAhoCorasick matcher = new StringMatcherAhoCorasick();

		Automaton data = matcher.constructACAutomaton(powerValues);

		for (int a0 = 0; a0 < noOfTestCases; a0++) {
			String mainStr = in.next();

			System.out.println(matcher.match(data, mainStr).size());
		}

		in.close();
	}
}