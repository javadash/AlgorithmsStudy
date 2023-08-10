package com.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class TreeTraversal {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    
	    public TreeNode(int val) {
	        this.val = val;
	        this.left = null;
	        this.right = null;
	    }
	}

    
    // Depth First Search (DFS) using recursion
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }
    
    // Breadth First Search (BFS) using a queue
    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeTraversal.TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.print("Depth First Search (DFS): ");
        dfs(root);
        
        System.out.println();
        
        System.out.print("Breadth First Search (BFS): ");
        bfs(root);
    }
}
