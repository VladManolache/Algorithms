package algorithms.sequences.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * @author Vlad Manolache
 */
public class TwoSumTest {
    
    @Test
    public void mainTest() {
        int[] numbers = { 2, 7, 11, 15 };
        TwoSum twoSum = new TwoSum();
        Arrays.equals(twoSum.getTwoSum(9, numbers), new int[]{0, 1});
    }
    
}
