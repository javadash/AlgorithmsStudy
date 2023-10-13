package TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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


    private int index = 0;

    public TreeNode buildTree(int[] preorder) {
        return buildTree(preorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = buildTree(preorder, root.val);
        root.right = buildTree(preorder, bound);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public void bfs (TreeNode root) {
        if (root == null ) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);

            if (node.left != null) queue.offer(node.left);

            if (node.right != null) queue.offer(node.right);
        }
    }


}