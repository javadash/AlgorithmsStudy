package com.data.structures;


public class BinarySearchTree {
	
	
	private class Node {
		private Node left;
		private Node right;
		private int value;
		
		public Node( Node left, Node right, int value ){
			this.left = left;
			this.right = right;
			this.value = value;
		}
		
		public Node getLeft() { return left; }
		public Node getRight() { return right; }
		public int getValue() { return value; }
	}
	
	public Node findNodeRe (Node root, int value) {
		while (root != null) {
			int curVal = root.getValue();
			if(curVal == value) return root;
			if(curVal < value) { return findNodeRe( root.getRight(), value ); } 
			else { return findNodeRe( root.getLeft(), value ); }
		}
		return null;
	}

}
