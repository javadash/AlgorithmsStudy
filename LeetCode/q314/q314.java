package q314;

import java.util.*;

import TreeNode.TreeNode;

public class q314 {
    public Map<Integer, List<Integer>> resultMap = new TreeMap<>();

/*
// This does not provide the correct solution
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        verticalOrderHelper(root, 0);

        for (Map.Entry<Integer, List<Integer>> entry : resultMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public void verticalOrderHelper(TreeNode root, int col) {
        if (root != null) {
            verticalOrderHelper(root.left, col - 1);
            verticalOrderHelper(root.right, col + 1);

            resultMap.computeIfAbsent(col, (k) -> new ArrayList<>());
            resultMap.get(col).add(root.val);
        }
    }*/

    // We need to use breath first search
    // BFS uses queue
    // DFS uses recursion
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : resultMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void printNestedList(List<List<Integer>> nestedList) {
        System.out.print("[ ");
        for (List<Integer> innerList : nestedList) {
            System.out.print("[");
            for (int i = 0; i < innerList.size(); i++) {
                System.out.print(innerList.get(i));
                if (i < innerList.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (nestedList.indexOf(innerList) < nestedList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        // preorder [3,9,8,4,0,1,7]
        // inOrder = [4, 9, 0, 3, 1, 8, 7]
        int[] preOrder = new int[] {3,9,8,4,0,1,7};
        int[] inOrder = new int[] {4, 9, 0, 3, 1, 8, 7};

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        q314 verticalOrder = new q314();
        List<List<Integer>> result = verticalOrder.verticalOrder(root);
        printNestedList(result);

    }
}