package algorithms.sequences;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Vlad Manolache
 */
public class LongestIncreasingSubsequence {
 
    
    public static void main(String[] args) {
        
        int[] S = {2,4,3,5,1,7,6,9,8};
        int n = S.length;
        System.out.print("S = ");
        for (int i = 0; i < n; i++) {
            System.out.print(S[i] + " ");
        } 
        
        longestIncreasingSubsequence(S);
    }
    
    public static Object[] longestIncreasingSubsequence(int[] S) {
        int n = S.length;
        int[] l = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i ++) {
            l[i] = 1;
            pos[i] = -1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (S[j] < S[i] && l[j] + 1 > l[i]) {
                    l[i] = l[j] + 1;
                    pos[i] = j;
                }
            }
        }
        
        System.out.println();
        System.out.print("Length array = ");
        for (int i = 0; i < n; i++) {
            System.out.print(l[i] + " ");
        }
        System.out.println();
        System.out.print("Pos array = ");
        for (int i = 0; i < n; i++) {
            System.out.print(pos[i] + " ");
        } 
        
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (l[i] > maxValue) {
                maxValue = l[i];
                maxIndex = i;
            }
        } 
        
        System.out.println();
        System.out.print("Max substring = ");
        ArrayList<Integer> solution = new ArrayList<>();
        int nextIndex = maxIndex;
        while(nextIndex != -1) {
            solution.add(S[nextIndex]);
            nextIndex = pos[nextIndex];
        }
        
        Collections.reverse(solution);
        System.out.println(solution);
        
        return solution.toArray();
    }
}
