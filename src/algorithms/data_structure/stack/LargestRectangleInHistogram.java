package algorithms.data_structure.stack;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where 
 *  the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * Example:
 * Given height = [2,1,5,6,2,3],+ 
 * return 10.
 * 
 * Links:
 * https://www.youtube.com/watch?v=ZmnqCZp9bBs
 * http://stackoverflow.com/questions/4311694/maximize-the-rectangular-area-under-histogram
 * 
 * Solution: 
 * Idea - Can we the first smaller bar on the left and on the right of each
 *  element in O(1) time ? Yes, by using an increasing stack.
 * For stack[x], stack[x-1] is the first smaller on its left, then a new element 
 *  that can pop stack[x] out is the first smaller on its right.
 * 
 * @author Vlad Manolache
 */
public class LargestRectangleInHistogram {
    
    final private Stack<Integer> stack;
    
    public LargestRectangleInHistogram() {
        stack = new Stack<>();
    }
    
    public int getLargestRectangle(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        int h;
        int w;  
        
        for (int i = 1; i < n; i++) {
            if ( stack.empty() || heights[stack.peek()] <= heights[i] ) {
                stack.push(i);
            }
            else {
                while ( !stack.empty() && heights[stack.peek()] > heights[i] ) {
                    h = heights[stack.pop()];
                    if ( !stack.empty() ) {
                        w = i - stack.peek() - 1;
                        maxArea = Math.max(maxArea, w * h);
                    } 
                }
                stack.push(i);
            }
        }
        
        while ( !stack.empty() ) {
            h = heights[stack.pop()];
            if ( !stack.empty() ) {
                w = n - 1 - stack.peek();  
                maxArea = Math.max(maxArea, w * h); 
                System.out.println("max=" + maxArea);
            }
        } 
        
        return maxArea;
    }
}
