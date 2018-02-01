package algorithms.search.binary.find_in_rotated_array;

import java.util.List;

/**
 * Priority: High
 * Difficulty: Medium
 * Companies: Adobe, Amazon

 * Description:
 * n element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an
 *  element in the rotated array in O(log n) time.
 *
 * Example:
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 3
 * Output : Found at index 8
 *
 * @author Vlad Manolache
 */
public class FindInRotatedArray {

    public int pivotedBinarySearch(List<Integer> list, int key) {
        int n = list.size();
        int pivot = findPivot(list, 0, n - 1);

        // If we didn't find a pivot, then array is not rotated at all
        if (pivot == -1) {
            return binarySearch(list, 0, n - 1, key);
        }

        // If we found a pivot, then first compare with pivot and then search in two sub-arrays around pivot.
        if (list.get(pivot) == key) {
            return pivot;
        }
        if (list.get(0) <= key) {
            return binarySearch(list, 0, pivot - 1, key);
        }
        return binarySearch(list, pivot+1, n - 1, key);
    }

    private int findPivot(List<Integer> list, int low, int high) {
        // base cases
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }

        int mid = (low + high) / 2;
        if (mid < high && list.get(mid) > list.get(mid + 1)) {
            return mid;
        }
        if (mid > low && list.get(mid) < list.get(mid - 1)) {
            return (mid - 1);
        }
        if (list.get(low) >= list.get(mid)) {
            return findPivot(list, low, mid - 1);
        }
        return findPivot(list, mid + 1, high);
    }

    /* Standard Binary Search function */
    private int binarySearch(List<Integer> list, int low, int high, int key) {
        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (key == list.get(mid)) {
            return mid;
        }
        if (key > list.get(mid)) {
            return binarySearch(list, (mid + 1), high, key);
        }
        return binarySearch(list, low, (mid -1), key);
    }

}
