package algorithms.sequences.subsequence;

/**
 * Given an array of integers, find a contiguous sub-array which has the largest sum.
 *
 * Example:
 * Given the array [-2, 2, -3, 4, -1, 2, 1, -5, 3], the contiguous sub-array [4,-1, 2, 1]
 *  has the largest sum = 6.
 *
 * @author Vlad Manolache
 */
public class LargestContiguousSubarray {

    public static int[] largestContiguousSubarray(int[] S) {

        int start = 0;
        int end = 0;
        int current = 0;
        int sum = 0;
        int maxSum = 0;

        for (int i = 1; i < S.length; i++) {
            sum += S[i];
            if (maxSum < sum) {
                maxSum = sum;
                start = current;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                current = i + 1;
            }
        }

        int[] results = new int[end - start + 1];
        System.arraycopy(S, start, results, 0, end - start + 1);
        return results;
    }

}
