package algorithms.sort;
    
/**
 * Implementation of mergeSort algorithm.
 * 
 * @author Vlad Manolache 
 */
public class MergeSort {
    
    public void executeMergeSort(int[] S) {
        mergeSort(S, 0, S.length - 1);
    }
    
    private void mergeSort(int[] S, int low, int high) {
        
        if (low < high) {
            int middle = low + (high - low) / 2;  // Avoid potential buffer overflow.
            mergeSort(S, low, middle);
            mergeSort(S, middle + 1, high);
            merge(S, low, middle, high);
        } 
    }
    
    private void merge(int[] S, int low, int middle, int high) {
        // Precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays.

        // Copy S to a temporary array.
        int[] tempMergArr = new int[S.length];
        for (int i = low; i <= high; i++) {
            tempMergArr[i] = S[i];
        }

        
        // Copy the smallest values from either the left or the right side back 
        // to the original array.
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                S[k++] = tempMergArr[i++]; 
            } else {
                S[k++] = tempMergArr[j++]; 
            } 
        }
        
        // Copy the rest of the left side of the array into the target array.
        while (i <= middle) {
            S[k++] = tempMergArr[i++]; 
        }
    } 
}
