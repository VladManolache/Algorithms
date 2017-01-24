package algorithms.search;

/**
 * Given n pieces of wood with length L[i] (integer array). Cut them into small 
 * pieces to guarantee you could have equal or more than k pieces with 
 * the same length. What is the longest length you can get from the 
 * n pieces of wood? Given L & k, return the maximum length of the small pieces.
 * You couldn't cut wood into float length.
 * 
 * Example:
 * For L=[232, 124, 456], k=7, return 114.
 * 
 * @author Vlad Manolache
 */
public class WoodCut {
    
    public int getWoodCut(int[] values, int length) {
        
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        
        int start = 0;
        int end = max;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPieces(mid, values) >= length) {
                start = mid;
            }
            else if (getPieces(mid, values) < length) {
                end = mid;
            }
        }
        
        return start;
    }
    
    private int getPieces(int k, int[] values) {
        int pieces = 0; 
        for (int i = 0; i < values.length; i++) {
            pieces += values[i] / k;
        }
        return pieces;
    }
    
}
