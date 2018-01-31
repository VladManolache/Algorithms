package algorithms.sequences.three_pointers.three_closest_three_arrays;

import java.util.List;

/**
 * Priority: High
 * Companies: Google, Microsoft, Yahoo
 *
 * Description:
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 *
 * Find i, j, k such that:
 * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 *
 * Example :
 *
 * Input :
 * A : [1, 4, 10]
 * B : [2, 15, 20]
 * C : [10, 12]
 *
 * Output : 5
 * With 10 from A, 15 from B and 10 from C.
 *
 * @author Vlad Manolache
 */
public class ThreeClosest3Arrays {

    public int minimize(List<Integer> A, List<Integer> B, List<Integer> C) {
        int i, j, k;

        // assigning the length - 1 value to each of three variables
        i = A.size() - 1;
        j = B.size() - 1;
        k = C.size() - 1;

        int min_diff, current_diff, max_term;

        // calculating min difference from last index of lists
        min_diff = Integer.MAX_VALUE;

        while (i != -1 && j != -1 && k != -1) {
            current_diff = diff(A, B, C, i, j, k);

            if (current_diff < min_diff) {
                min_diff = current_diff;
            }

            max_term = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            // Moving to smaller value in the array with maximum out of three.
            if (A.get(i) == max_term) {
                i -= 1;
            }
            else if (B.get(j) == max_term) {
                j -= 1;
            }
            else {
                k -= 1;
            }
        }
        return min_diff;
    }

    private int diff(List<Integer> A, List<Integer> B, List<Integer> C, int i, int j, int k) {
        int maxBC = Math.max(B.get(j), C.get(k));
        int maxABC = Math.max(A.get(i), maxBC);

        int minBC = Math.min(B.get(j), C.get(k));
        int minABC = Math.min(A.get(i), minBC);

        return Math.abs(maxABC - minABC);
    }

}
