package com.helpermonkey.algomed;

import java.util.ArrayList;

public class LinkedListCycle {
	/*
	 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if
	 * the list is empty.
	 * 
	 * A Node is defined as: class Node { int data; Node next; }
	 */

	boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;

		ArrayList<ListNode> nodeRepeated = new ArrayList<ListNode>();
		nodeRepeated.add(head);
		return recurseNodes(head.next, nodeRepeated);

	}

	boolean recurseNodes(ListNode child, ArrayList<ListNode> nodeRepeated) {
		if (nodeRepeated.contains(child)) {
			// there is a cycle
			return true;
		}

		if (child.next != null) {
			nodeRepeated.add(child);
			return recurseNodes(child.next, nodeRepeated);
		} else {
			// we have reached the end of linked list.
			return false;
		}
	}

	public static void main(String[] args) {

		LinkedListCycle cycle = new LinkedListCycle();
		
		ListNode a = new ListNode(1, null);
		ListNode b = new ListNode(2, a);
		ListNode c = new ListNode(3, b);
		ListNode d = new ListNode(4, c);
		ListNode e = new ListNode(5, d);
		
		d.next = e;
		
		ListNode current = e;
		System.out.println(cycle.hasCycle(current));
	}

}