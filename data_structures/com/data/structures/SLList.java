package com.data.structures;



/**
 * A single linked list implementation on Java
 * @author Johnson
 *
 * @param <T>
 */
public class SLList<T> {	
	private class Node {
		public T item;
		public Node next;

		public Node(T i, Node n) {
			item = i;
			next = n;
		}
	} 

	private Node first;
	private int size;

	public SLList(T x) {
		first = new Node(x, null);
		size = 1;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(T x) {
 		first = new Node(x, first);
 		size += 1;
 	}

 	/** Returns the first item in the list. */
 	public T getFirst() {
 		return first.item; 		
 	}
 	
 	/** Deletes the first item in the list. */
 	//Make the second element in the list the new head, the Java garbage collector will later remove the old head
 	public T deleteFirst() {
 		Node temp = first;
 		first = first.next;
 		return temp.item;
 	}

 	/** Adds an item to the end of the list. */
 	public void addLast(T x) {
 		size += 1;
 		Node p = first;
 		/* Move p until it reaches the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}
 		p.next = new Node(x, null);
 	}

 	public int size() {
 		return size;
 	}
 	
 	public void printList() {
 		Node p = first;
 		while(p.next!=null){
			System.out.print(p.item + " ");
			p = p.next;
		}
		System.out.println();
 	}
}