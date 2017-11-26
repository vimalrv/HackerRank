package com.helpermonkey.practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class ContactsTree {
    public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(
				new FileInputStream(new File("/Users/vimalsekar/3_Projects/java/HackerRank/contact-input-1.txt")));

        int n = scan.nextInt();
        Tree trie = new Tree();
        for (int i = 0; i < n; i++) {
        		if(!scan.hasNext())
        			break;
        	
            String operation = scan.next();
            String contact   = scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();
        
		long endTime = System.currentTimeMillis();
		System.out.println("total time=" + (endTime - startTime));
    }
}

/* Based loosely on tutorial video in this problem */
class TreeNode {
    private HashMap<Character, TreeNode> children = new HashMap<>();
    public int size;

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TreeNode());
    }

    public TreeNode getChild(char ch) {
        return children.get(ch);
    }
}

class Tree {
    TreeNode root = new TreeNode();

    Tree(){} // default constructor
    
    Tree(String[] words) {
        for (String word : words) {
            add(word);
        }
    }
    
    public void add(String str) {
        TreeNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }
    
    public int find(String prefix) {
        TreeNode curr = root;
        
        /* Traverse down tree to end of our prefix */
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}