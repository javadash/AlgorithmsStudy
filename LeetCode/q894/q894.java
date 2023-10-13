package q894;

import TreeNode.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class q894 {
    TreeNode root = new TreeNode(0);
    List<TreeNode> al = new ArrayList<>();

    // All possible full binary trees given the number of nodes
    // all nodes have a value of 0
    public List<TreeNode> allPossibleFBT (int n) {
        if( n % 2 == 0) return al; // impossible to produce even num full tree

        List<TreeNode> unprocessed = new ArrayList<>();
        generateTrees(n - 1, root, unprocessed);
        return al;
    }

    // combinatorial search with backtracking, at each step either set two children or set 0 children
    public void generateTrees (int n, TreeNode node, List<TreeNode> unprocessed) {
        if ( n == 0 ) {
            al.add(cloneTree(root));
            return;
        }

        node.left = new TreeNode(0);
        node.right = new TreeNode(0);

        unprocessed.add(node.left);
        unprocessed.add(node.right);

        // go over every combination of dfs expansion based on unprocessed candidates
        for (int i = 0; i < unprocessed.size(); i++) {
            generateTrees(n - 2, unprocessed.get(i), new ArrayList<>(unprocessed.subList( i + 1, unprocessed.size())));
            unprocessed.get(i).left = null;
            unprocessed.get(i).right = null;
            if (n - 2  == 0) return; // don't double count duplicates
        }
    }

    private TreeNode cloneTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = cloneTree(node.left);
        newNode.right = cloneTree(node.right);
        return newNode;
    }

    public static void main(String[] args) {
        q894 solution = new q894();
        int nodes = 7;
        System.out.printf("The number of full binary trees for %d nodes is %d . %n", nodes, solution.allPossibleFBT(nodes).size());
    }

}