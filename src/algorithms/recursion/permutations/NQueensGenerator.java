package algorithms.recursion.permutations;

/**
 *
 * @author Vlad Manolache
 */
public class NQueensGenerator {

    private int solutionCount = 0;
    
    public int generateNQueens(int n) {
        int[][] board = new int[n][n];
        solutionCount = 0;
        buildNQueens(n, board, 0, n, 0);
        return solutionCount;
    }

    private void buildNQueens(int matrixSize, int[][] board, int currentColumn,
            int queenCount, int currentQueenCount) {

        if (currentQueenCount == queenCount) {
            solutionCount++;
            return;
        }

        int j = currentColumn;
        for (int i = 0; i < matrixSize; i++) {

            boolean isEmpty = true;
            for (int k = 0; k < matrixSize; k++) {
                if (board[i][k] == 1) {
                    isEmpty = false;
                    break;
                } else if (board[k][j] == 1) {
                    isEmpty = false;
                    break;
                } else if (i - k >= 0 && j - k >= 0 && board[i - k][j - k] == 1) {
                    isEmpty = false;
                    break;
                } else if (i + k < matrixSize && j + k < matrixSize && board[i + k][j + k] == 1) {
                    isEmpty = false;
                    break;
                } else if (i - k >= 0 && j + k < matrixSize && board[i - k][j + k] == 1) {
                    isEmpty = false;
                    break;
                } else if (i + k < matrixSize && j - k >= 0 && board[i + k][j - k] == 1) {
                    isEmpty = false;
                    break;
                }
            }

            if (isEmpty) {
                board[i][j] = 1;

                buildNQueens(matrixSize, board, currentColumn + 1, queenCount, currentQueenCount + 1);
                
                // backtracking ...
                board[i][j] = 0;
            }
        } 
    }
}
