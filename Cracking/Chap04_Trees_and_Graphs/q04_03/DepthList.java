package Chap04_Trees_and_Graphs.q04_03;


import java.util.*;

import com.data.structures.TreeNode;

public class DepthList {
	public static void createDepthList (TreeNode node, int depth, List<LinkedList<TreeNode>> result) {

		List<LinkedList<TreeNode>> test = new ArrayList<>();
		while(depth > result.size()){
			result.add(new LinkedList<TreeNode>());
		}
		result.get(depth - 1).add(node);
	}

	public static int depth(TreeNode node) {
		if (node == null) return 0;
		return 1 + depth(node.parent);
	}
	
	public static List<LinkedList<TreeNode>> getNodesDepthList(TreeNode root) {
		List<LinkedList<TreeNode>> depthList = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
        	TreeNode curr = queue.poll();
            if (curr != null) {
				int nodeDepth = depth(curr);
				System.out.printf("Current Node data = %d Depth = %d %n", curr.getData(), nodeDepth);
				createDepthList(curr, nodeDepth, depthList);
				List<TreeNode> children = new ArrayList<>(){{
            		add(curr.left);
            		add(curr.right);
            	}};
            	TreeNode[] childr = new TreeNode[]{
            		curr.left, 
            		curr.right
            	};
	            for (TreeNode node : children) {
	                if (!visited.contains(node)) {
	                    visited.add(node);
	                    queue.add(node);

	                }
	            }
            }
        }

        return depthList;
    }

	public static void printNestedArrayList(List<LinkedList<TreeNode>> nestedList) {
		for (LinkedList<TreeNode> innerList : nestedList) {
			for (TreeNode element : innerList) {
				System.out.print(element.getData() + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * public List<Integer> getReachableNodesRecursive(TreeNode root) {
	 * List<Integer> result = new ArrayList<>(); Set<Integer> visited = new
	 * HashSet<>(); dfs(start, visited, result); return result; }
	 * 
	 * private void dfs(int curr, Set<Integer> visited, List<Integer> result) { if
	 * (adjacencyList.get(curr) == null) return; visited.add(curr);
	 * result.add(curr); for (Integer neighbor : adjacencyList.get(curr)) { if
	 * (!visited.contains(neighbor)) { dfs(neighbor, visited, result); } } }
	 */
	
	public static void main(String[] args) {
		int [] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
		TreeNode mintree = TreeNode.createMinimalBST(arr);
		printNestedArrayList(getNodesDepthList(mintree));
	}
}
