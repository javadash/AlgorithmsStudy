package com.data.structures;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author Johnson
 * @date 04/05/2019
 * @param <T>
 */

public class BST1 <T extends Comparable<T>> {
	private int nodeCount;
	private Node root;
	private class Node {
		private Node left;
		private Node right;
		private T element;
		
		public Node( Node left, Node right, T element ){
			this.left = left;
			this.right = right;
			this.element = element;
		}
		
		public Node getLeft() { return left; }
		public Node getRight() { return right; }
		public T getValue() { return element; }
	}
	// Get the number of nodes in this binary tree
	public int size() {
		return nodeCount;
	}
	
	// Check if this binary tree is empty
	public boolean isEmpty() {
		return size() == 0;
	}
	
	
	// Add an element to this binary tree. 
	// Returns true if we successfully perform an insertion
	public boolean add(T element) {
		if(contains(element)) {
			return false;
		} else {
			root = add(root, element);
			nodeCount++;
			return true;
		}
	}
	
	//Private method to recursively add a element to the binary tree - skips duplicates
	private Node add(Node node, T element) {
		if(node == null) { //Base case - found leaf node
			node = new Node(null, null, element);
		} else {
			if(element.compareTo(node.element) < 0) {
				node.left = add(node.left, element);
			} else { 
				node.right = add(node.right, element); 
			}
		}
		return node;
	}
	
	//Remode based on eager Hibbard deletion
	public void removeMin() {
		root = removeMin(root);
	}
	
	//Delete minimum element node- go left until reaching th key with null left link
	private Node removeMin(Node node) {
		if(node.left == null) return node.right;
		node.left = removeMin(node.left);
		return node;
	}
	
	public boolean remove(T element) {
		if(contains(element)) {
			root = remove(root , element);
			nodeCount--;
			return true;
		}
		return false;
	}
	
	public Node remove(Node node, T element) {
		if(node == null) return null;
		int cmp = element.compareTo(node.element);
		
		// Keep looking left for values smaller than current element
		if(cmp < 0) {node.left = remove(node.left, element);} 
		// Keep looking right for values greater than current element
		else if (cmp > 0) {node.right = remove(node.right, element);}
		else  {
			if (node.right == null) return node.left;
			if (node.left == null) return node.right;
			
			// Removing a Node with two child nodes
			Node t = node;
			// Setting node to point to its successor -> min(t.right).
			// Successor is the node with the smallest key in its right subtree.
			node = min(t.right);
			/* Set the right link of node (which is supposed to
					point to the BST containing all the keys larger
					than node.key) to removeMin(t.right), the link
					to the BST containing all the keys that are larger
					than node.key after the deletion */
			
			/* Set the left link of node (which was null) to t.left
					(all the elements that are less than both the deleted
					element and its successor) */
			node.right = removeMin(t.right);
			node.left = t.left;
		}
		return node;
	}
	
	public T min() {
		return min(root).element;
	}
	
	// Find the maximum element in the tree - recursive
	private Node min(Node node) {
		if (node.left == null) return node;
		return min(node.left);
	}
	
	public T max() {
		return max(root).element;
	}
	
	// Find the maximum element in the tree - Iterative
	private Node max(Node node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	// returns true is the element exists in the tree
	public boolean contains(T element) {
		return contains(root, element);
	}
	
	// private recursive method to check element in the tree
	private boolean contains(Node node, T element) {
		//Base case: reached leaf and element not found
		if(node == null) return false;
		
		int cmp = element.compareTo(node.element);
		if(cmp < 0) return contains(node.left, element);
		else if (cmp > 0) return contains(node.right, element);
		else return true; // element found
	}
	
	// Computes the height of the tree O(n)
	public int height() {
		return height(root);
	}
	
	// Recursive helper method to calculate the tree height
	private int height(Node node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	public void print() {
		print(root);
	}
	
	private void print(Node node) {
		if (node == null) return;
		print(node.left);
		System.out.println(node.element);
		print(node.right);
	}
	
	// recursive and iterative solutions for In Order Depth First Traversal
	public List<T> inOrder() {
		List<T> list=new ArrayList<>();
		//inOrderIterative(root, list);
		inOrderRecursive(root, list);
		return list;
	}
	
	private void inOrderIterative(Node node, List<T> list) {
		Stack<Node> nodeStack = new Stack<>();
		while(node != null || !nodeStack.isEmpty()) {
			while(node != null) {
				nodeStack.push(node);
				node = node.left;
			}
			node = nodeStack.pop();
			list.add(node.element);
			node = node.right;
		}
	}
	
	private void inOrderRecursive(Node node, List<T> list) {
		if(node == null) return;
		inOrderRecursive(node.left, list);
		list.add(node.element);
		inOrderRecursive(node.right, list);
	}

	// recursive and iterative solutions for Pre Order Depth First Traversal
	public List<T> preOrder() {
		List<T> list=new ArrayList<>();
		//preOrderRecursive(root, list);
		preOrderRecursive(root, list);
		return list;
	}
	
	private void preOrderIterative (Node node, List<T> list) {
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.add(node);
		while(node != null || !nodeStack.isEmpty()) {
			Node x = nodeStack.pop();
			list.add(x.element);
            if(x.left!=null)
                nodeStack.add(x.left);
            if(x.right!=null)
                nodeStack.add(x.right);
		}
	}
	
	private void preOrderRecursive (Node node, List<T> list) {
		if(node == null) return;
		list.add(node.element);
		if(node.left!=null) preOrderRecursive(node.left, list);
		if(node.left!=null) preOrderRecursive(node.right, list);
	}
	
	// recursive and iterative solutions for Post Order Depth First Traversal
	public List<T> postorder() {
        List<T> list = new ArrayList<>();
        if( root == null) return list;
        postOrderIterative(root, list);
        //postOrderRecursive(root, list);
        return list;
    }
    void postOrderRecursive(Node x, List<T> list){
        if(x==null)return;
        if(x.left!=null)
            postOrderRecursive(x.left, list);
        if(x.right!=null)
            postOrderRecursive(x.right, list);
        list.add(x.element);
    }
    void postOrderIterative(Node root, List<T> list){
        Set<Node> set= new HashSet<>();
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        set.add(null);
        while(!stack.isEmpty()){
            Node peek=stack.peek();
            if( (set.contains(peek.left) && set.contains(peek.right))){
                list.add(stack.pop().element);
                set.add(peek);
            }else{
                if(peek.right!=null)
                    stack.push(peek.right);
                if(peek.left!=null)
                    stack.push(peek.left);
            }
        }
    }
	
	
	public static void main(String args[]) {
		BST1<Integer> numberTree = new BST1<>();
		for(int i = 0; i < 20; i++) {
			int value = (int) (100 * Math.random());
			numberTree.add(value);
		}
		//numberTree.print();
		numberTree.inOrder().stream().forEach(System.out::println);
		System.out.println(numberTree.size());
 	}
}
