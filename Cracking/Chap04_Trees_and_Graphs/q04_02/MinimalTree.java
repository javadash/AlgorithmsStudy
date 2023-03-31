package Chap04_Trees_and_Graphs.q04_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.data.structures.TreeNode;

public class MinimalTree {
	// recursive for In Order Depth First Traversal
	public static List<Integer> inOrder(TreeNode node) {
		return inorderIterative(node);
	}
	
	public static List<Integer> inorderIterative(TreeNode root) {
	    List<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode current = root;
	    
	    while (current != null || !stack.isEmpty()) {
	        while (current != null) {
	            stack.push(current);
	            current = current.left;
	        }
	        
	        current = stack.pop();
	        result.add(current.getData());
	        current = current.right;
	    }
	    
	    return result;
	}
	

	public static List<Integer> inOrderRecursive(TreeNode node) {
		List<Integer> result = new ArrayList<Integer>();
		if(node == null) return result;
		
		List<Integer> leftHand = inOrderRecursive(node.left);
		
		result.addAll(leftHand);
		result.add(node.getData());
		
		List<Integer> rightHand =  inOrderRecursive(node.right);
		result.addAll(rightHand);
		return result;
	}
	
	public static void print(TreeNode node) {
		inOrder(node).stream().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		int [] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
		TreeNode mintree = TreeNode.createMinimalBST(arr);
		print(mintree);
	}
}
