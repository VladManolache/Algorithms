package algorithms.sequences.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {

    public static Object[] longestIncreasingSubsequence(int[] S) {

        // initialise the length and position arrays. Initially, each element is it's own sub-array.
        int n = S.length;
        int[] l = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i ++) {
            l[i] = 1;
            pos[i] = -1;
        }
        
        // build length and position arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (S[j] < S[i] && l[j] + 1 > l[i]) {
                    l[i] = l[j] + 1;
                    pos[i] = j;
                }
            }
        }
        
        System.out.println();
        System.out.println("Length array = " + Arrays.toString(l));
        System.out.println("Pos array = " + Arrays.toString(pos));
        
        // pick maximum. 
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (l[i] > maxValue) {
                maxValue = l[i];
                maxIndex = i;
            }
        } 
        
        // print solution.
        System.out.println();
        System.out.print("Max substring = ");
        ArrayList<Integer> solution = new ArrayList<>();
        int nextIndex = maxIndex;
        while(nextIndex != -1) {
            solution.add( S[nextIndex] );
            nextIndex = pos[nextIndex];
        }
        Collections.reverse(solution);
        System.out.println(solution);
        
        return solution.toArray();
    }
    
}
