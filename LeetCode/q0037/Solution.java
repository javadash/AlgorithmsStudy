package q0037;

public class Solution {
	public static void solveSudoku(char[][] board) {
		dfs(board, 0);
	}
	
	public static boolean dfs (char[][] board, int s) {
		if(s == 81) {
			return true;
		}
		
		final int i = s / 9;
		final int j = s % 9;
		
		if (board[i][j] != '.')
		      return dfs(board, s + 1);
		
		for(char c = '1'; c <= '9'; c++) {
			if(isValidChoice(board, i , j, c)) {
				board[i][j] = c;
				if (dfs(board, s + 1)) return true;
				board[i][j] = '.';
			}
		}
		return false;
	}

	private static boolean isValidChoice(char[][] board, int row, int col, char c) {
		for (int k = 0; k < 9; k++ ){
			if (board[k][col] == c || board[row][k] == c || 
					board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) {
				return false;				
			}
		}
		return true;
	}
	
	public static void printNestedCharArray(char[][] arr) {
	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr[i].length; j++) {
	            System.out.print(arr[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		char[][] board = new char [][] { 
			new char [] {'5','3','.','.','7','.','.','.','.'},
			new char [] {'6','.','.','1','9','5','.','.','.'},
			new char [] {'.','9','8','.','.','.','.','6','.'},
			new char [] {'8','.','.','.','6','.','.','.','3'},
			new char [] {'4','.','.','8','.','3','.','.','1'},
			new char [] {'7','.','.','.','2','.','.','.','6'},
			new char [] {'.','6','.','.','.','.','2','8','.'},
			new char [] {'.','.','.','4','1','9','.','.','5'},
			new char [] {'.','.','.','.','8','.','.','7','9'}
		};
		
		solveSudoku(board);
		
		printNestedCharArray(board);
	}

}
