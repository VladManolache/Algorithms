package algorithms.math;

import java.util.List;

/**
 * Priority: High
 * Companies: Microsoft, Amazon
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Examples:
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 20, 50, 113 → 20, 113, 50
 *
 * @author Vlad Manolache
 */
public class NextPermutation {

    public void nextPermutation(List<Integer> a) {
        int i = a.size() - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) {
            i--;
        }
        if (i >= 0) {
            int j = a.size() - 1;
            while (j >= 0 && a.get(j) <= a.get(i)) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i + 1);
    }

    private void reverse(List<Integer> a, int start) {
        int i = start;
        int j = a.size() - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private void swap(List<Integer> a, int i, int j) {
        int tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
