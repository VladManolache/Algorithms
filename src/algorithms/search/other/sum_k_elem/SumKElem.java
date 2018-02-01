package algorithms.search.other.sum_k_elem;

import java.util.ArrayList;
import java.util.Comparator;

/** 
 * Given a set S of n integers and an integer T, give an O(n^(k−1) log n) algorithm
 * to test whether k of the integers in S add up to T.
 * 
 * @author Vlad Manolache
 */
public class SumKElem {
 
    public static Integer[] sort(int[] array) {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        arrayList.sort(Comparator.naturalOrder());

        return arrayList.toArray(new Integer[arrayList.size()]);
    }

    public static boolean checkSumK(Integer[] S, int k, int T) {

        if (k <= 2) {
            return checkSumBinary(S, T);
        }

        Integer A[] = new Integer[S.length - 1];
        
        for (int i = 0; i < S.length; i++) {

            // Generate A by copying S[j] without including S[i].
            k = 0;
            for (int j = 0; j < S.length; j++) {
                if (i != j) {
                    A[k] = S[j];
                    k++;
                }
            }

            // Check condition on newly generated array A. 
            if (checkSumK(A, k - 1, T - S[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSum(Integer[] S, int x) {
        int n = S.length; 
        int j = n - 1;

        for (int i = 0; i < j; i++) {
            while ((i < j) && (S[j] + S[i] > x)) {
                j--;
            }
            if (x == (S[j] + S[i])) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkSumBinary(Integer[] S, int x) {
        int j;
        for (int i = 1; i < S.length; ++i) {
            j = x - S[i];
            if (binarySearch(S, j, i + 1, S.length - 1) != -1) {
                return true;
            }
        }
        return false;
    }

    private static int binarySearch(Integer[] S, int key, int min, int max) {
        if (max < min) {
            return -1;
        } else {
            int mid = min + ((max - min) / 2);  // Calculated using difference to avoid overflow.

            if (S[mid] > key) {
                return binarySearch(S, key, min, mid - 1);
            } else if (S[mid] < key) {
                return binarySearch(S, key, mid + 1, max);
            } else {
                return mid;
            }
        }
    }

    public static int iterativeBinarySearch(Integer[] S, int key, int min, int max) {
        // Continue searching while [imin, imax] is not empty
        while (min <= max) {
            int mid = min + ((max - min) / 2);  // Calculated using difference to avoid overflow.
            
            if (S[mid] == key) {
                return mid;
            } else if (S[mid] < key) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        // key was not found
        return -1;
    }

}
