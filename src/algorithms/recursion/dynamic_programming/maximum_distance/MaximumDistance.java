package algorithms.recursion.dynamic_programming.maximum_distance;

import java.util.List;

/**
 * Priority: High
 * Companies: Google, Amazon
 *
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * If there is no solution possible, return -1.
 *
 * Example:
 * Input: [3 5 4 2]
 * Output: 2 for the pair (3, 4)
 *
 * @author Vlad Manolache
 */
public class MaximumDistance {

    public int findMaximumDistance(final List<Integer> A) {
        int n = A.size();
        int[] RMax = new int[n];
        int[] LMin = new int[n];

        // RMax[i] stores the max value between i and n-1.
        RMax[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            RMax[i] = Math.max(RMax[i + 1], A.get(i));
        }

        // LMax[i] stores the min value between 0 and i.
        LMin[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(LMin[i - 1], A.get(i));
        }

        // Merge results from the two lists.
        int i = 0;
        int j = 0;
        int maxDiff = -1;
        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            }
            else {
                i = i + 1;
            }
        }

        return maxDiff;
    }

}
