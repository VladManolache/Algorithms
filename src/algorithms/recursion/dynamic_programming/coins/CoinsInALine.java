package algorithms.recursion.dynamic_programming.coins;

import java.util.Arrays;

/**
 * Description:
 * There are n coins in a line. Two players take turns to take one or two coins 
 *  from right side until there are no more coins left. 
 * The player who take the last coin wins.
 * Could you please decide the first play will win or lose?
 * 
 * Example:
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 * 
 * @author Vlad Manolache
 */
public class CoinsInALine {
    
    public boolean firstPlayerWins(int n) {
        if (n == 1) return true;
        if (n == 2) return true;
        if (n == 3) return false;
 
        boolean[] f = new boolean[n];
        f[0] = true;
        f[1] = true;
        f[2] = false;
        
        // work your way from the end. We want to be the one taking the last 
        //  coin which means neither f[n-1] or f[n-2] can win.
        for (int i = 3; i < n; i++) {
            if ( !f[i - 1] || !f[i - 2] ) {
                f[i] = true;
            }
        }
        
        System.out.println( Arrays.toString(f) );
        
        return f[n - 1];
    }
    
}
