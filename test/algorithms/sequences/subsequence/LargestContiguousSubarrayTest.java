package algorithms.sequences.subsequence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LargestContiguousSubarrayTest {


    @Test
    void smallTest() {
        int[] S = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Arrays.toString(S));

        int[] result = LargestContiguousSubarray.largestContiguousSubarray(S);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(result, new int[] {4, -1, -2, 1, 5});
    }

    @Test
    void mainTest() {
        int[] S = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        System.out.println(Arrays.toString(S));

        int[] result = LargestContiguousSubarray.largestContiguousSubarray(S);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(result, new int[] {4, -1, 2, 1});
    }

    @Test
    void testAllNegative() {
        int[] S = {-2, -3, -4, -1, -2};
        System.out.println(Arrays.toString(S));

        int[] result = LargestContiguousSubarray.largestContiguousSubarray(S);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(result, new int[] {-2});
    }

    @Test
    void testAllPositive() {
        int[] S = {2, 3, 4, 1, 2};
        System.out.println(Arrays.toString(S));

        int[] result = LargestContiguousSubarray.largestContiguousSubarray(S);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(result, new int[] {2, 3, 4, 1, 2});
    }
}
