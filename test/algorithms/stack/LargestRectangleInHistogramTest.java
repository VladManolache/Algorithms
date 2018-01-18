package algorithms.stack;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class LargestRectangleInHistogramTest {
    
    @Test
    public void mainTest_V1() {
        int[] heights = new int[] {2,1,5,6,2,3};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        assert(largestRectangleInHistogram.getLargestRectangle(heights) == 10);
    }
    
    @Test
    public void mainTest_V2() {
        int[] heights = new int[] {6, 2, 5, 4, 5, 1, 6};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        assert(largestRectangleInHistogram.getLargestRectangle(heights) == 12);
    }
    
    @Test
    public void secondaryTest() {
        int[] heights = new int[] {2,1,2,3,1};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        assert(largestRectangleInHistogram.getLargestRectangle(heights) == 4);
    }
    
}
