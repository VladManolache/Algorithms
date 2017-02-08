package algorithms.sort;

import java.util.Random;

/**
 * Implementation of quickSort algorithm.
 * More info: 
 * V1 quicksort tutorial - http://www.algolist.net/Algorithms/Sorting/Quicksort
 * V2 quicksort tutorial - https://www.youtube.com/watch?v=aQiWF4E8flQ
 * V2 works faster usually, but works much slower in the worst case when the values
 * are already sorted and even crashes on sorted inputs of 100000 and larger.
 *
 * @author Vlad Manolache
 */
public class QuickSort {

    Random rand = new Random(); 
    
    public void executeSort(int[] S, boolean v1) {
        if (v1) {
            quickSortV1(S, 0, S.length - 1);
        }
        else {
            quickSortV2(S, 0, S.length - 1);
        }
    } 
    
    private void quickSortV1(int[] S, int l, int h) {
        int i = l, j = h;
        int aux; 
        
        // We need to get a random index between l and h to avoid bad performance
        //  in the case that the array is already sorted.
        int value = rand.nextInt(h - l + 1) + l; 
        int pivot = S[value];
        
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             *  is greater then the pivot value, and also we will identify a number
             *  from right side which is less then the pivot value. Once the search
             *  is done, then we exchange both numbers.
             */ 
            while (S[i] < pivot) {
                i++;
            }
            while (S[j] > pivot) {
                j--;
            }
            
            if (i <= j) {
                aux = S[i];
                S[i] = S[j];
                S[j] = aux;
                i++;
                j--;
            }
        }
        
        // At this point, j should be smaller than i by 1.
        // This means the intervals will be (l, j) and (i, h).
        if (l < j) {
            quickSortV1(S, l, j);
        }
        if (i < h) {
            quickSortV1(S, i, h); 
        } 
    }
    
    private void quickSortV2(int[] S, int l, int h) {
        int p; 

        if (h - l > 0) {
            // The partition element should not be excluded from the search.
            // This means the intervals will be (l, p-1) and (p+1, h).
            p = partition(S, l, h);
            quickSortV2(S, l, p - 1);
            quickSortV2(S, p + 1, h);
        }
    }

    private int partition(int[] S, int l, int h) {
        int aux;
        int p = h;
        int leftWall = l; 
        
        // Move all elements larger than pivot to right of leftWall. 
        // Move lefWwall to right each time.
        for (int i = l; i < h; i++) { 
            if (S[i] < S[p]) {
                aux = S[i];
                S[i] = S[leftWall];
                S[leftWall] = aux; 
                leftWall++;
            } 
        }
        
        // Swap pivot with S[firsthigh]. Since we have moved everything bigger
        //  than S[p] to the right, this will mean all elements to the left of 
        //  S[p] will be smaller than S[p].
        aux = S[p];
        S[p] = S[leftWall];
        S[leftWall] = aux; 
        
        return leftWall; 
    }
}
