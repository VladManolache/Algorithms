package algorithms.recursion.dynamic_programming.grid_unique_paths;

/**
 * Priority: High
 * Companies: Google, Amazon, Microsoft, Adobe
 *
 * Description:
 * A robot is located at the top-left corner of an A x B grid.
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 *  the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 * Example :
 *
 * Input : A = 2, B = 2
 * Output : 2
 *
 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 * OR  : (0, 0) -> (1, 0) -> (1, 1)
 *
 * @author Vlad Manolache
 */
public class GridUniquePaths {

    public int countPaths_recursive(int n, int m) {
        return executeCountPaths_recursive(n - 1, m - 1, 0);
    }

    private int executeCountPaths_recursive(int i, int j, int count) {
        if (i < 0 || j < 0) {
            return count;
        }
        if (i == 0 && j == 0) {
            return count + 1;
        }

        return executeCountPaths_recursive(i - 1, j, count) +
                executeCountPaths_recursive(i, j - 1, count);
    }

    public int countPaths_dynamic(int n, int m) {
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            grid[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[n - 1][m - 1];
    }

}
