package q1530;

public class q1530 {
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        postOrder(root, distance);
        return this.count;
    }

    private int[] postOrder(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }

        // essentially at each node we want to create an array for each leaf node
        // the array index is the distance and the value at the index is the number of leaf nodes
        // root = [1,2,3,4,5,6,7], distance = 3
        // E.g. at the root node
        // left = [ 0,0,1,0,0]
        // right = [0,1,0,0,0]
        // Here, left[2] = 1, which denotes that there is one leaf node with distance 2 in left subtree of root node 1.
        // right[1] = 1, which denotes that there is one leaf node with distance 1 in right subtree of root node 1.

        if (node.left == null && node.right == null) {
            int[] res = new int[distance + 1];
            res[1]++; // This calculates the distance of one root leaf node to the parent
            return res;
        }
        int[] leftDist = postOrder(node.left, distance);
        int[] rightDist = postOrder(node.right, distance);
        int[] res = new int[distance + 1];

        // Using out array we check if the left and right side of the node have leaf nodes that sum up to less or equal to our distance
        // Essentially for distance 3 we should go from 1 - 2 on both left and right side (1 + 1 < 2, 2 + 1 <= 3)
        for (int l = 1; l < distance; l++) {
            for (int r = distance - 1; r >= 0; r--) {
                if (l + r <= distance) this.count += leftDist[l] * rightDist[r];
            }
        }

        // Here will deal with updating the parent of the leaf node
        // We want to the distance for parents by adding up left and right subtrees of current node.
        // Note that we are doing - res[i+1] = left[i]+right[i];

        // The idea is that, if a leaf node is at distance i from current node,
        // it would be at distance i+1 from its parent.
        // Hence, will building the res array, we are adding the sum of the left * right ith position to the i+1 th position of the result and return to parent.

        for (int i = res.length - 2 ; i >= 1; i--) {
            res[i + 1] = leftDist[i] + rightDist[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root  = new TreeNode();
        root = root.buildTree(preorder);
        root.printTree(root);
        System.out.println();
        q1530 solution = new q1530();
        System.out.println("The solution for the selected tree is: " + solution.countPairs(root, 3));
        // You can now use 'root' to traverse the binary tree in preorder to verify the result.
        // The tree should have the structure you specified.
    }
}
