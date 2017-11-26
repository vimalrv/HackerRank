package com.helpermonkey.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class BinarySearchTreeCheck {

	/*
	 * Hidden stub code will pass a root argument to the function below. Complete
	 * the function to solve the challenge. Hint: you may want to write one or more
	 * helper functions.
	 * 
	 * The Node class is defined as follows: class Node { int data; Node left; Node
	 * right; }
	 */
	boolean checkBST(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		HashSet<Integer> noDuplicate = new HashSet<Integer>();
		HashMap<Integer, Integer> traversedParent = new HashMap<Integer, Integer>();
		if (root.left == null) {
			if (root.right == null) {
				return true;
			} else {
				return traverseAndValidate(1, root.data, root.right, noDuplicate, traversedParent);
			}
		} else {
			if (traverseAndValidate(0, root.data, root.left, noDuplicate, traversedParent)) {
				if (root.right == null) {
					return true;
				} else {
					traversedParent = new HashMap<Integer, Integer>();
					return traverseAndValidate(1, root.data, root.right, noDuplicate, traversedParent);
				}
			} else {
				return false;
			}
		}
	}

	boolean hasTraversed(HashMap<Integer, Integer> traversedParent, int currentValue, int currentDirection) {
		for (Iterator<Integer> iterator = traversedParent.keySet().iterator(); iterator.hasNext();) {
			Integer traversedValue = iterator.next();
			Integer traversedDirection = traversedParent.get(traversedValue);
			if (currentDirection == 1) {
				if (currentValue >= traversedValue.intValue() && traversedDirection == 0) {
					System.out.println("traversed:cv-"+currentValue+":trv-"+traversedValue+"cd-1:trvd-0");
					return false;
				}
			}else {
				if (currentValue <= traversedValue.intValue() && traversedDirection == 1) {
					System.out.println("traversed:cv-"+currentValue+":trv-"+traversedValue+"cd-0:trvd-1");
					return false;
				}
			}
		}
		return true;
	}

	boolean traverseAndValidate(int direction, int parentValue, Node childNode, HashSet<Integer> noDuplicate,
			HashMap<Integer, Integer> traversedParent) {
		noDuplicate.add(new Integer(parentValue));
		traversedParent.put(new Integer(parentValue), new Integer(direction));
		if (noDuplicate.contains(new Integer(childNode.data))) {
			System.out.println("duplicate:" + childNode.data);
			return false;
		}

		if (direction == 0 ? parentValue <= childNode.data : parentValue >= childNode.data) {
			System.out.println("parentValue <> childValue per direction:" + parentValue + "p-c" + childNode.data + "-d"
					+ direction);
			return false;
		} else {
			if (!hasTraversed(traversedParent, childNode.data, direction)) {
				return false;
			}

			if (childNode.left == null) {
				if (childNode.right == null) {
					return true;
				} else {
					return traverseAndValidate(1, childNode.data, childNode.right, noDuplicate, traversedParent);
				}
			} else {
				if (traverseAndValidate(0, childNode.data, childNode.left, noDuplicate, traversedParent)) {
					if (childNode.right == null) {
						return true;
					} else {
						return traverseAndValidate(1, childNode.data, childNode.right, noDuplicate, traversedParent);
					}
				} else {
					return false;
				}
			}
		}
	}

	// if (parentValue < childNode.data) {
	// if (childNode.left == null) {
	// return false;
	// } else {
	// return contains(parentValue, childNode.left);
	// }
	// } else {
	// if (childNode.right == null) {
	// return false;
	// } else {
	// return contains(parentValue, childNode.right);
	// }
	// }
	//
	// }
	//
	// boolean recurseNodes(Node child, ArrayList<Node> nodeRepeated) {
	// if (nodeRepeated.contains(child)) {
	// // there is a cycle
	// return true;
	// }
	//
	// if (child.next != null) {
	// nodeRepeated.add(child);
	// return recurseNodes(child.next, nodeRepeated);
	// } else {
	// // we have reached the end of linked list.
	// return false;
	// }
	// }

	public static void main(String[] args) throws Exception {

		BinarySearchTreeCheck bst = new BinarySearchTreeCheck();

		

		// BufferedReader reader = new BufferedReader(new FileReader(new
		// File("/Users/vimalsekar/3_Projects/java/HackerRank/bst-input-1.txt")));
		// String input = reader.readLine();
		// String[] inputArr = input.split(" ");

		// for (int i = 1; i < inputArr.length; i++) {
		// a.insert(new Integer(inputArr[i]).intValue());
		// }
		//
		// a.printInOrder();
		//
		// System.out.println("length " + inputArr.length );

		// reader.close();
		
		Node a = new Node(3);

//TC 1
		a.insert(2);
		a.insert(1);
		a.insert(5);
		//a.insert(4);
		a.insert(7);
		a.insert(6);

// TC custom 7		
//		a.insert(5);
//		a.insert(2);
//		a.insert(3);
//		a.insert(1);
//		a.insert(6);
//		
//		a.insert(9);
//		a.insert(8);
//		a.insert(11);
//		a.insert(10);
//		a.insert(12);
		
		
		a.printInOrder();

		// a.insert(18);a.insert(30);
		// a.insert(16); a.insert(19);
		// a.insert(16);
		// a.insert(17);
		//
		// a.insert(32);

		System.out.println(bst.checkBST(a));
	}

}