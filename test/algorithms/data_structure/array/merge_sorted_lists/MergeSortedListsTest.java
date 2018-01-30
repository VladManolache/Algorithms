package algorithms.data_structure.array.merge_sorted_lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MergeSortedListsTest {

    @Test
    void mainTest() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,5,8));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(6,9));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(1,5,6,8,9));
        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        mergeSortedLists.merge(a, b);
        assert(a.equals(expectedResult));
    }

}
