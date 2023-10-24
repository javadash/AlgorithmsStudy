package q2458;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TreeNode.TreeNode;

public class q2458 {


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


    Map<Integer, Integer> depthMap = new HashMap<>();
    Map<Integer, Integer> heightMap = new HashMap<>();
    Map<Integer, List<Integer[]>> depthPeers = new HashMap<>();

    int maxHeight = Integer.MIN_VALUE;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int [] result = new int[queries.length];
        dfs(root, 0);

        for (Map.Entry<Integer, Integer> dm : depthMap.entrySet()) {
            int nodeVal = dm.getKey();
            int depth = dm.getValue();
            depthPeers.computeIfAbsent(depth, key -> new ArrayList<>());
            depthPeers.get(depth).add(new Integer[] {heightMap.get(nodeVal), nodeVal});
            depthPeers.get(depth).sort(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] arr1, Integer[] arr2) {
                    return arr2[0].compareTo(arr1[0]);
                }
            });
        }

        for (int i = 0; i < queries.length; i++) {
            int nodeVal = queries[i];
            int depth = depthMap.get(nodeVal);

            List<Integer[]> currPairs = depthPeers.get(depth);
            if(currPairs.size() == 1) {
                result[i] = depth - 1;
            } else if(currPairs.get(0)[1] == nodeVal) {
                result[i] = currPairs.get(1)[0] + depth;
            } else {
                result[i] = currPairs.get(0)[0] + depth;
            }
        }
        return result;
    }

    public int dfs(TreeNode node, int height) {
        if (node == null) {
            return - 1;
        }
        depthMap.put(node.val, height);
        int currHeight  = Math.max(dfs(node.left, height + 1), 
        		dfs(node.right, height + 1)) + 1;
        heightMap.put(node.val, currHeight);
        return currHeight;
    }
}