package com.helpermonkey.algoeasy.graphtheory;

import java.util.Scanner;
import java.util.TreeSet;

public class EvenTree {

	public int traverseAndFind(EventNode rootNode) {
		int noOfTrees = 0;
		TreeSet<EventNode> nodesList = rootNode.getChildren();

		for (EventNode node : nodesList) {
			if (node.hasChild()) {
				noOfTrees += traverseAndFind(node);
			}

			if ((node.childDepth != 0) && (node.childDepth % 2 > 0)) {
				noOfTrees++;
			}
		}

		// do the same for the root node
//		if ((rootNode.childDepth != 0) && (rootNode.childDepth % 2 > 0)) {
//			noOfTrees++;
//		}

		return noOfTrees;
	}

	public EventNode createTree(int[] left, int[] right) {
		int rootNodeValue = -1;
		for (int i = 0; i < right.length; i++) {
			boolean foundRoot = true;
			for (int j = 0; j < left.length; j++) {
				if (right[i] == left[j]) {
					foundRoot = false;
					break;
				}
			}
			if (foundRoot) {
				rootNodeValue = right[i];
			}
		}

		EventNode rootNode = new EventNode(rootNodeValue);
		for (int i = 0; i < right.length; i++) {
			rootNode.attachChild(right[i], left[i]);
		}

		return rootNode;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int[] left = new int[m];
		int[] right = new int[m];

		for (int i = 0; i < m; i++) {
			left[i] = in.nextInt();
			right[i] = in.nextInt();
		}

		EvenTree evenTree = new EvenTree();
		EventNode rootNode = evenTree.createTree(left, right);

		System.out.println(evenTree.traverseAndFind(rootNode));

		in.close();

	}

	// TreeMap tree = new TreeMap();
	// TreeSet tree = new TreeSet();
	// tree.add(rootNodeValue);
	// for (int i = 0; i < left.length; i++) {
	// }

	class EventNode implements Comparable {
		public int data;

		public int childDepth;

		public TreeSet<EventNode> children = new TreeSet<EventNode>();

		EventNode(int data) {
			this.data = data;
		}

		public TreeSet<EventNode> getChildren() {
			return children;
		}

		public boolean hasChild() {
			return !children.isEmpty();
		}

		public EventNode attachChild(int parentValue, int childValue) {
			if (parentValue == this.data) {
				EventNode child = new EventNode(childValue);
				children.add(child);
				childDepth++;
				return this;
			} else {
				for (EventNode node : children) {
					EventNode attachedParent = node.attachChild(parentValue, childValue);
					if (attachedParent != null) {
						childDepth++;
						return node;
					}
				}
			}

			return null;
		}

		public EventNode find(int nodeValue) {
			EventNode curNode = new EventNode(nodeValue);

			for (EventNode node : children) {
				if (node.equals(curNode)) {
					return node;
				}
			}

			return null;
		}

		@Override
		public int compareTo(Object o) {
			if(this.data > ((EventNode)o).data) {
				return 1;
			}else if(this.data < ((EventNode)o).data) {
				return -1;
			}
			return 0;
		}
	}

}