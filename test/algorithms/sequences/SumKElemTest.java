package algorithms.sequences;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad Manolache
 */
public class SumKElemTest {

    @Test
    public void mainTest() {
        int array[] = {2, -1, 5, 3, 1, 2, 6, 4};

        Integer[] integerArray = SumKElem.sort(array);
        boolean result = SumKElem.checkSumK(integerArray, 2, 9);
        System.out.println(result);

        assertTrue(result == true);
    }
}
