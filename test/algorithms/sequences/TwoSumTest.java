package algorithms.sequences;

import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class TwoSumTest {
    
    @Test
    public void mainTest() {
        int[] numbers = { 2, 7, 11, 15 };
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.getTwoSum(9, numbers)));
    }
    
}
