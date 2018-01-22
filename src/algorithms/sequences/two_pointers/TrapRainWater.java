package algorithms.sequences.two_pointers;

/**
 * Given n non-negative integers representing an elevation map where the width 
 *  of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Example:
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Vlad Manolache
 */
public class TrapRainWater {
    
    public int getTrappedRainWater_V1(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        
        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > heights[left]) {
                    res += leftHeight - heights[left];
                } else {
                    leftHeight = heights[left];
                }
            } else {
                right--;
                if (rightHeight > heights[right]) {
                    res += rightHeight - heights[right];
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return res;
    }
    
    public int getTrappedRainWater_V2(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        
        int n = heights.length; 
        int[] left = new int[n];
        int[] right = new int[n];
        
        // left[i] contains height of tallest bar to the left of i including itself.
        left[0] = heights[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], heights[i]);
        }
           
        // right[i] contains height of tallest bar to the right of i including itself.
        right[n-1] = heights[n-1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], heights[i]);
        }

        // water is trapped if the current element is between two larger sections. 
        //  In that case, we calcuate the trapped water height by substracting 
        //  the current height from the minimum of the two larger sections.
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.min(left[i], right[i]) - heights[i];
        }
                
        return max;
    }
    
}
