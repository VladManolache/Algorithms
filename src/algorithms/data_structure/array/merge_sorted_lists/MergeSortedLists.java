package algorithms.data_structure.array.merge_sorted_lists;

import java.util.ArrayList;

/**
 * Priority: Low
 * Difficulty: Easy
 * Companies: Adobe, Expedia, Microsoft
 *
 * Description:
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 *
 * If the number of elements initialized in A and B are m and n respectively,
 *  the resulting size of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 * A : [1 5 8]
 * B : [6 9]
 *
 * Output:
 * Modified A : [1 5 6 8 9]
 *
 * @author Vlad Manolache
 */
public class MergeSortedLists {

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;

        ArrayList<Integer> results = new ArrayList<>();
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                results.add(a.get(i));
                i++;
            }
            else {
                results.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            results.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            results.add(b.get(j));
            j++;
        }

        a.clear();
        a.addAll(results);
    }

}
