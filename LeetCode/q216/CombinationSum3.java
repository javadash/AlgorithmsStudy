package q216;

import java.util.*;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combination(res, new ArrayList<>(), k , n, 1);
        return res;
    }

    public static void combination(List<List<Integer>> result, List<Integer> comb, int k, int n, int start) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            result.add(li);
            return;
        }
        for (int i = start; i <= n && i <= 9; i++) {
            comb.add(i);
            combination(result, comb, k,n-i, i+1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void printResult(List<List<Integer>> result) {
        System.out.print("[");

        for (List<Integer> res : result) {
            System.out.print("[");

            for (int i : res) {
                System.out.print(i);
                if (i != res.get(res.size() - 1)) {
                    System.out.print(", "); // Add a comma and space if it's not the last row
                }
            }
            System.out.print("]");
            if (res != result.get(result.size() - 1)) {
                System.out.print(", "); // Add a comma and space if it's not the last row
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        List<List<Integer>> solution = CombinationSum3.combinationSum3(3, 9);
        printResult(solution);
    }
}
