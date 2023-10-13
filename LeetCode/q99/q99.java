package q99;


//Definition for a binary tree node.

public class q99 {

    // we want to use inOrder traversal to turn 6, 3, 4, 5, 2 int 2, 3, 4, 5, 6
    // prev is set to Integer.MIN_VALUE to avoid null pointer


    TreeNode first, second;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree (TreeNode root){

        // inOrder traversal to find the two elements
        traverse(root);
        if (root == null) {
            return;
        }

        // swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void traverse (TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        // Prev will be used to save the previously visited node in the tree
        // For inOrder traversal we should have the root greater than the previous visited node
        // Essentially we are checking that order is maintained 1, 2, 3, 4, 5, 6
        // We have not found the first of two elements we want to swap
        // We set the first element to the Integer.MIN_VALUE
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        // We are checking if the first element to swap has been found then ->
        // We assign root to the second element
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5, 6};
        TreeNode root = new TreeNode();
        root = root.buildTree(preorder);
        root.printTree(root);
        // You can now use 'root' to traverse the binary tree in preorder to verify the result.
        // The tree should have the structure you specified.
    }
}
