package algorithms.math;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NextPermutationTest {

    @Test
    void testSimple() {
        List<Integer> input = Arrays.asList(20, 50, 113);

        List<Integer> expectedResults = Arrays.asList(20, 113, 50);

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(input);
        assert(input.equals(expectedResults));
    }

    @Test
    void testEndOfRange() {
        List<Integer> input = Arrays.asList(3, 2, 1);

        List<Integer> expectedResults = Arrays.asList(1, 2, 3);

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(input);
        assert(input.equals(expectedResults));
    }

    @Test
    void testComplex() {
        List<Integer> input = Arrays.asList(
                251, 844, 767, 778, 658, 337, 10, 252,
                632, 262, 707, 506, 701, 475, 410, 696,
                631, 903, 516, 149, 344, 101, 42, 891, 991
        );

        List<Integer> expectedResults = Arrays.asList(
                251, 844, 767, 778, 658, 337, 10, 252,
                632, 262, 707, 506, 701, 475, 410, 696,
                631, 903, 516, 149, 344, 101, 42, 991, 891
        );

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(input);
        assert(input.equals(expectedResults));
    }

}
