 package q51;

 import java.util.ArrayList;
import java.util.List;

 public class NQueensSolver {
    public static void main(String[] args) {
        int n = 4; // Change this value to the desired board size
        int[] Q = new int[n + 1]; // Array to store queen positions
        List<List<String>> result = new ArrayList<>();
        solveNQueens1(Q, 1, n, result);
        printBoard(result);
    }

    public static void solveNQueens(int[] Q, int k, int n) {
        if (k == n + 1) {
            printSolution(Q);
            return;
        }

        for (int j = 1; j <= n; j++) {
            boolean valid = true;
            for (int i = 1; i < k; i++) {
                if (Q[i] == j || Q[i] == j + k - i || Q[i] == j - k + i) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                Q[k] = j;
                solveNQueens(Q, k + 1, n);
            }
        }
    }



    public static void solveNQueens1(int[] Q, int k, int n, List<List<String>> result) {
        if (k == n + 1) {
            printSolution(Q);
            result.add(transformToBoard(Q));
            return;
        }

        for (int j = 1; j <= n; j++) {
            boolean valid = true;
            for (int i = 1; i < k; i++) {
                if (Q[i] == j || Q[i] == j + k - i || Q[i] == j - k + i) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                Q[k] = j;
                solveNQueens1(Q, k + 1, n, result);
            }
        }
    }


     public static List<String> transformToBoard(int[] queenPositions) {
         int n = queenPositions.length;
         List<String> board = new ArrayList<>();

         for (int i = 1; i < n; i++) {
             StringBuilder row = new StringBuilder();
             for (int j = 1; j < n; j++) {
                 if (j == queenPositions[i]) {
                     row.append("Q");
                 } else {
                     row.append(".");
                 }
             }
             board.add(row.toString());
         }

         return board;
     }


     public static void printSolution(int[] Q) {
        for (int i = 1; i < Q.length; i++) {
            System.out.print(Q[i] + " ");
        }
        System.out.println();
    }

     public static void printBoard(List<List<String>> result) {
         System.out.print("[");

         for (List<String> res : result) {
             System.out.print("[");

             String rowString = String.join(", ", res); // Join the row elements with ", "
             System.out.print(rowString);

             System.out.print("]");
             if (res != result.get(result.size() - 1)) {
                 System.out.print(", "); // Add a comma and space if it's not the last row
             }
         }

         System.out.print("]");
     }
}



