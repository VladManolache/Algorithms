package algorithms.sequences.two_pointers.three_sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Vlad Manolache
 */
public class ThreeSumTest {
    
    @Test
    void mainTest() {
        int[] numbers = new int[] {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        
        ArrayList<ArrayList<Integer>> expectedResults = new ArrayList<>();
        ArrayList<Integer> firstResult = new ArrayList<>(Arrays.asList(-1,-1,2));
        ArrayList<Integer> secondResult = new ArrayList<>(Arrays.asList(-1,0,1));
        expectedResults.add(firstResult);
        expectedResults.add(secondResult);
        
        assert(expectedResults.equals(threeSum.threeSumPairs(numbers)));
    }
    
}
