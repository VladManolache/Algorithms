package algorithms.data_structure.matrix;

/**
 * Description:
 * Given an image represented by an NxN matrix, where each pixel in
 * the image is 4 bytes, write a method to rotate the image by 90
 * degrees. Can you do this in place?
 * 
 * Link: https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * 
 * First Cycle (Involves marked Elements)
 * *1*  *2*  *3* *4* 
 * *5*  6  7  *8* 
 * *9* 10 11 *12* 
 * *13* *14* *15* *16* 
 * 
 * Moving first group of four elements (First
 * elements of 1st row, last row, 1st column 
 * and last column) of first cycle in counter
 * clockwise. 
 * *4*  2  3 *16*
 * 5  6  7 8 
 * 9 10 11 12 
 * *1* 14  15 *13* 
 * 
 * Moving next group of four elements of 
 * first cycle in counter clockwise 
 * 4  *8*  3 16 
 * 5  6  7  *15*  
 * *2*  10 11 12 
 * 1  14  *9* 13 
 * 
 * Moving final group of four elements of 
 * first cycle in counter clockwise 
 * 4  8 *12* 16 
 * *3*  6  7 15 
 * 2 10 11 *14* 
 * 1  *5*  9 13 
 * 
 * Second Cycle (Involves marked Elements)
 * 4  8 12 16 
 * 3  *6* *7*  15 
 * 2  *10* *11* 14 
 * 1  5  9 13 
 * 
 * Fixing second cycle
 * 4  8 12 16 
 * 3  *7* *11* 15 
 * 2  *6* *10* 14 
 * 1  5  9 13
 * 
 * @author Vlad Manolache
 */
public class MatrixRotate {
    
    public static int[][] rotate90Right(int[][] matrix) {
        int n = matrix.length;
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = matrix[n-1-j][i];
            }
        }
        return ret;
    }
    
    public static int[][] rotate90Left(int[][] matrix) {
        int n = matrix.length;
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = matrix[j][n-1-i];
            }
        }
        return ret;
    }
    
    public static int[][] rotate90LeftInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - 1 - i; ++j) {
                // store current cell in temp variable
                int tmp = matrix[i][j];
                // move values from right to top
                matrix[i][j] = matrix[j][n-1-i];
                // move values from bottom to right
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j];
                // move values from left to bottom
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i];
                // assign temp to right
                matrix[n-1-j][i] = tmp;
            }
        }
        return matrix;
    }
    
    public static int[][] rotate90RightInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - 1 - i; ++j) {
                // store current cell in temp variable
                int tmp = matrix[i][j];
                // move values from left to top
                matrix[i][j] = matrix[n-1-j][i];
                // move values from top to right
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                // move values from right to bottom
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                // assign temp to left
                matrix[j][n-1-i] = tmp;
            }
        }
        return matrix;
    }
    
    public static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
