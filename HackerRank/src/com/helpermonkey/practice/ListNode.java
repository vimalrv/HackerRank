package com.helpermonkey.practice;

public class ListNode {
	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as: 
	    class Node {
	        int data;
	        Node next;
	    }
	*/
	
	public int data;
	public ListNode next;
	
	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}


}