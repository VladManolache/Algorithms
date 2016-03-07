
package algorithms.sequences;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad Manolache
 */
public class LongestIncreasingSubsequenceTest {
      
    
     @Test
     public void hello() {
        int[] S = {2,4,3,5,1,7,6,9,8};
        int n = S.length;
        System.out.print("S = ");
        for (int i = 0; i < n; i++) {
            System.out.print(S[i] + " ");
        } 
        
        Object[] result = LongestIncreasingSubsequence.longestIncreasingSubsequence(S);
        assertArrayEquals(result, new Object[] {2, 4, 5, 7, 9});
     }
}
