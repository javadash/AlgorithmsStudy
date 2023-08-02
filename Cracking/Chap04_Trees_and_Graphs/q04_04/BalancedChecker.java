package Chap04_Trees_and_Graphs.q04_04;

import com.data.structures.TreeNode;

public class BalancedChecker {
	
	public static int getHeight (TreeNode node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	public static boolean isBalanced (TreeNode node) {
		if (node == null) {
			return false;
		}
		int heightDiff = getHeight(node.left) - getHeight(node.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}
}
