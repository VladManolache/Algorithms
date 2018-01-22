package algorithms.data_structure.hash_map;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * @author Vlad Manolache
 */
public class TwoSumTest {
    
    @Test
    void mainTest() {
        int[] numbers = { 2, 7, 11, 15 };
        TwoSum twoSum = new TwoSum();
        assert(Arrays.equals(twoSum.getTwoSum(9, numbers), new int[]{0, 1}));
    }
    
}
