package algorithms.recursion.dynamic_programming.maximum_distance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaximumDistanceTest {

    @Test
    void simpleTest() {
        List<Integer> a = new ArrayList<>(Arrays.asList(3, 5, 4, 2));
        MaximumDistance maximumDistance = new MaximumDistance();
        assert(maximumDistance.findMaximumDistance(a) == 2);
    }

    @Test
    void mainTest() {
        List<Integer> a = new ArrayList<>(Arrays.asList(34, 8, 10, 3, 2, 80, 30, 33, 1));
        MaximumDistance maximumDistance = new MaximumDistance();
        assert(maximumDistance.findMaximumDistance(a) == 6);
    }
}
