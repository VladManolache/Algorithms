package algorithms.sequences.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        ArrayList<Integer> firstResult = new ArrayList<>();
        firstResult.add(-1);
        firstResult.add(-1);
        firstResult.add(2);
        expectedResults.add(firstResult);
        ArrayList<Integer> secondResult = new ArrayList<>();
        secondResult.add(-1);
        secondResult.add(0);
        secondResult.add(1);
        expectedResults.add(secondResult);
        
        assert(expectedResults.equals(threeSum.getThreeSumPairs(numbers)));
    }
    
}
