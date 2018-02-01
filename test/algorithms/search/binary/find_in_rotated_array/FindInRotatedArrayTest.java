package algorithms.search.binary.find_in_rotated_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindInRotatedArrayTest {

    @Test
    void mainTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10, 1, 2, 3));
        int key = 3;
        FindInRotatedArray findInRotatedArray = new FindInRotatedArray();
        assert(findInRotatedArray.pivotedBinarySearch(list, key) == 8);
    }

}
