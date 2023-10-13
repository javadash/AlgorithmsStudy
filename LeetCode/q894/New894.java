package q894;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class New894 {
    Map<Integer, List<TreeNode>> nodeMap = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<TreeNode>();

        List<TreeNode> ndlist = new ArrayList() {{
            add(new TreeNode(0));
        }};
        nodeMap.put(1, ndlist);

        for (int i = 2; i <= n; i++) {
            List<TreeNode> currList = new ArrayList<>();
            for (int j = 1; j < i; j += 2) {
                List<TreeNode> leftTrees = nodeMap.get(j);
                List<TreeNode> rightTrees = nodeMap.get(i - j - 1);

                if (leftTrees != null && rightTrees != null) {
                    for (TreeNode lt : leftTrees) {
                        for (TreeNode rt : rightTrees) {
                            currList.add(new TreeNode(0, lt, rt));
                        }
                    }
                }
            }
            nodeMap.put(i, currList);
        }
        return nodeMap.get(n);
    }

    public static void main(String[] args) {
        New894 solution = new New894();
        int nodes = 7;
        System.out.printf("The number of full binary trees for %d nodes is %d . %n", nodes, solution.allPossibleFBT(nodes).size());
    }
}
