package q105;

import java.util.*;

// Solution using Stacks

public class New105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        // deal with edge case(s)
        if (preorder.length == 0) {
            return null;
        }

        // build a map of the indices of the values as they appear in the inorder array
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }



        Deque<TreeNode> stack = new ArrayDeque<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);


        for (int i = 1; i < preorder.length; i++) {

            // create a node
            int val = preorder[i];
            TreeNode node = new TreeNode(val);

            if (inorderMap.get(val) < inorderMap.get(stack.peek().val)) {
                // the new node is on the left of the last node,
                // so it must be its left child (that's the way preorder works)
                stack.peek().left = node;
            } else {
                // the new node is on the right of the last node,
                // so it must be the right child of either the last node
                // or one of the last node's ancestors.
                // pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the right of the new node
                TreeNode parent = null;
                while(!stack.isEmpty() && inorderMap.get(val) > inorderMap.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }
}
