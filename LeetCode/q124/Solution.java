package q124;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return result;
    }

    public int maxPathSumHelper(TreeNode root) {

        if(root == null) return 0;

        int leftVal = Math.max(0, maxPathSumHelper(root.left)); // essentially we want to check if get a +ve value because it will reduce our max value is its -ve
        int rightVal = Math.max(0, maxPathSumHelper(root.right)); // same explaination as above
        int pathSum = root.val + leftVal + rightVal;

        result = Math.max(result, pathSum);
        return Math.max(leftVal, rightVal) + root.val; // here we want to get only the tree branch that leads to us having a max value and discard the other branch
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}