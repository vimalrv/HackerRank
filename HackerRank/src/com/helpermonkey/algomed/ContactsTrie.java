package com.helpermonkey.algomed;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class ContactsTrie {

	public static char[][] contacts = null;
	public static int addCntr = 0;

	public static final char[] ADD = { 'a', 'd', 'd' };

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(
				new FileInputStream(new File("/Users/vimalsekar/3_Projects/java/HackerRank/contact-input-1.txt")));
		int n = in.nextInt();
		contacts = new char[n][21];
		
		MasterNode rootMaster = new MasterNode();

		for (int a0 = 0; a0 < n; a0++) {
			if (!in.hasNext())
				break;
			String op = in.next();
			String contact = in.next();
			
			if ("add".equalsIgnoreCase(op)) {
				rootMaster.addWord(contact);
			} else {
				rootMaster.countPartialOccurance(contact);
			}
		}

		in.close();

		long endTime = System.currentTimeMillis();
		System.out.println("total time=" + (endTime - startTime));
	}
}

class AlphaNode {
	char alpha;
	HashMap<Character, AlphaNode> childMap;
	int noOfWords = 0;

	public AlphaNode(char currentChar) {
		alpha = currentChar;
		childMap = new HashMap<Character, AlphaNode>();
	}

	public void initializeAlphabets(char letter) {
		char currentChar = letter;
		AlphaNode childNode = childMap.get(new Character(currentChar));
		if (childNode == null) {
			childNode = new AlphaNode(currentChar);
			childMap.put(currentChar, childNode);
			return;
		}
	}

	public void insertRecursively(char[] nameLetters, int noOfCharTraversed) {
		if (noOfCharTraversed <= (nameLetters.length - 1)) {
			char currentChar = nameLetters[noOfCharTraversed];
			
			AlphaNode childNode = childMap.get(new Character(currentChar));
			if (childNode == null) {
				childNode = new AlphaNode(currentChar);
				childMap.put(currentChar, childNode);
			}
			
			childNode.noOfWords++;
			noOfCharTraversed++;
			childNode.insertRecursively(nameLetters, noOfCharTraversed);
		}
	}

	public AlphaNode find(char letter) {
		return childMap.get(new Character(letter));
	}

	public AlphaNode findRecursive(char[] prefixLetters, int noOfCharTraversed, AlphaNode child) {
		if (noOfCharTraversed <= (prefixLetters.length - 1)) {
			AlphaNode nextChild = child.childMap.get(new Character(prefixLetters[noOfCharTraversed]));
			if (nextChild != null) {
				noOfCharTraversed++;
				return findRecursive(prefixLetters, noOfCharTraversed, nextChild);
			} else {
				System.out.println(0);
				return null;
			}
		} else {
			// the prefix has completed, now find the num of words after ths path...
			System.out.println(child.noOfWords);
			return null;
		}
	}
}

class MasterNode {
	AlphaNode rootNode = new AlphaNode('-');
	static final char[] ALPHABETS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public MasterNode() {
		for (int i = 0; i < ALPHABETS.length; i++) {
			rootNode.initializeAlphabets(ALPHABETS[i]);
		}
		// trieDepth++;
	}

	public void addWord(String word) {
		char[] letters = word.toCharArray();

		rootNode.insertRecursively(letters, 0);
	}

	public void countPartialOccurance(String prefix) {
		char[] prefixLetters = prefix.toCharArray();

		rootNode.findRecursive(prefixLetters, 0, rootNode);
	}
}
