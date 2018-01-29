package algorithms.data_structure.array.plusone;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class PlusOneTest {

    @Test
    void mainTest() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,1,2,0,5,3,9));
        ArrayList<Integer> expectedOutput = new ArrayList<>(Arrays.asList(1,2,0,5,4,0));

        PlusOne plusOne = new PlusOne();
        assert(plusOne.plusOne(input).equals(expectedOutput));
    }

    @Test
    void testMinimum() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        ArrayList<Integer> expectedOutput = new ArrayList<>(Collections.singletonList(1));

        PlusOne plusOne = new PlusOne();
        assert(plusOne.plusOne(input).equals(expectedOutput));
    }

    @Test
    void testMaximum() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,9,9,9,9,9,9,9));
        ArrayList<Integer> expectedOutput = new ArrayList<>(Arrays.asList(1,0,0,0,0,0,0,0));

        PlusOne plusOne = new PlusOne();
        assert(plusOne.plusOne(input).equals(expectedOutput));
    }
}
