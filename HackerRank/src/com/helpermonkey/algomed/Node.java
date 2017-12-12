package com.helpermonkey.algomed;

import java.util.TreeSet;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public int childDepth;

	public TreeSet<Node> children;

	public Node(int data) {
		this.data = data;
	}
	
	public TreeSet<Node> getChildren(){
		return children;
	}
	
	public boolean hasChild() {
		return !children.isEmpty();
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);

			} else {
				right.insert(value);
			}
		}
	}

	public Node attachChild(int parentValue, int childValue) {
		if (parentValue == this.data) {
			Node child = new Node(childValue);
			children.add(child);
			childDepth++;
		} else {
			for (Node node : children) {
				Node attachedParent = node.attachChild(parentValue, childValue);
				if (attachedParent != null) {
					childDepth++;
					return node;
				}
			}
		}

		return null;
	}

	public Node find(int nodeValue) {
		Node curNode = new Node(nodeValue);

		for (Node node : children) {
			if (node.equals(curNode)) {
				return node;
			}
		}

		// if I am here it means no direct child here has the right node
		// for (Node node : children) {
		// if(node.find(nodeValue) != null) {
		// return node;
		// }
		// }

		return null;
	}

	/** Print InOrder traversal of tree **/
	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}

		System.out.print(data + " ");

		if (right != null) {
			right.printInOrder();
		}
	}

}