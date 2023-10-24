package q236;

import java.util.*;
import TreeNode.TreeNode;

public class q236 {
	Map<TreeNode, TreeNode> adj = new HashMap<>();

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<Integer> bucket = new ArrayList<>();
		Queue<TreeNode> numQue = new LinkedList<>();
		buildParents(root, null);

		numQue.offer(p);
		numQue.offer(q);

		while (!numQue.isEmpty()) {
			TreeNode currNode = numQue.poll();

			if (bucket.contains(currNode.val)) {
				return currNode;
			} else {
				bucket.add(currNode.val);
			}
			if (adj.containsKey(currNode)) {
				numQue.offer(adj.get(currNode));
			}
		}
		return null;
	}

	public void buildParents(TreeNode node, TreeNode parent) {
		if (node == null) {
			return;
		}

		if (node != null && parent != null) {
			adj.put(node, parent);
		}

		if (node.left != null) {
			buildParents(node.left, node);
		}

		if (node.right != null) {
			buildParents(node.right, node);
		}
	}
}
