/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

/**
 *
 * @author user
 */
public class QuickSort {

    public void executeSort(int[] S) {
        quickSort(S, 0, S.length - 1);
    }

    private void quickSort(int[] S, int l, int h) {
        int p; 

        if (h - l > 0) {
            p = partition(S, l, h);
            quickSort(S, l, p - 1);
            quickSort(S, p + 1, h);
        }
    }

    private int partition(int[] S, int l, int h) {
        
        int aux;
        int p = h;
        int firsthigh = l; 
        
        for (int i = l; i < h; i++) { 
            if (S[i] < S[p]) {
                aux = S[i];
                S[i] = S[firsthigh];
                S[firsthigh] = aux; 
                firsthigh++;
            } 
        }
        
        aux = S[p];
        S[p] = S[firsthigh];
        S[firsthigh] = aux; 
        return firsthigh; 
    }
}
