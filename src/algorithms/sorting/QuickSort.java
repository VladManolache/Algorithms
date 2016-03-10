/*
 * Implementation of quickSort algorithm.
 * More info: 
 * V1 quicksort tutorial - http://www.algolist.net/Algorithms/Sorting/Quicksort
 * V2 quicksort tutorial - https://www.youtube.com/watch?v=aQiWF4E8flQ
 */
package algorithms.sorting;

import java.util.Random;

/**
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
        
        int value = rand.nextInt(h - l + 1) + l; 
        int pivot = S[value];
        
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
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
            p = partition(S, l, h);
            quickSortV2(S, l, p - 1);
            quickSortV2(S, p + 1, h);
        }
    }

    private int partition(int[] S, int l, int h) {
        int aux;
        int p = h;
        int leftWall = l; 
        
        for (int i = l; i < h; i++) { 
            if (S[i] < S[p]) {
                aux = S[i];
                S[i] = S[leftWall];
                S[leftWall] = aux; 
                leftWall++;
            } 
        }
        
        // Swap pivot with S[firsthigh]
        aux = S[p];
        S[p] = S[leftWall];
        S[leftWall] = aux; 
        
        return leftWall; 
    }
}
