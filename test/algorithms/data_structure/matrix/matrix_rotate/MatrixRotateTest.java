package algorithms.data_structure.matrix.matrix_rotate;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
class MatrixRotateTest {
    
    int[][] a = {
            {1, 2, 3, 4, 5},
            {11,22,33,44,55},
            {5, 4, 3, 2, 1},
            {55,44,33,22,11},
            {6, 7, 8, 9, 0}
    };
    
    @Test
    void testRotateRight() {
        int[][] expectedResult = {
                 {6, 55, 5, 11, 1},
                 {7,44,4,22,2},
                 {8, 33, 3, 33, 3},
                 {9,22,2,44,4},
                 {0,11, 1, 55, 5}
        };
        assert(matrixAreEqual(expectedResult, MatrixRotate.rotate90Right(a)));
        assert(matrixAreEqual(expectedResult, MatrixRotate.rotate90RightInPlace(a)));
    }
    
    @Test
    void testRotateLeft() {
        int[][] expectedResult = {
                 {5, 55, 1, 11, 0},
                 {4,44,2,22,9},
                 {3, 33, 3, 33, 8},
                 {2,22,4,44,7},
                 {1,11, 5, 55, 6}
        };
        assert(matrixAreEqual(expectedResult, MatrixRotate.rotate90Left(a)));
        assert(matrixAreEqual(expectedResult, MatrixRotate.rotate90LeftInPlace(a)));
    }
    
    boolean matrixAreEqual(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}