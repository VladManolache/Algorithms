package algorithms.data_structure.array.prefixsum;

import java.util.Arrays;

/**
 * Say you have an array for which the i-th element is the price of a given 
 *  stock on day i. Design an algorithm to find the maximum profit. You may complete 
 *  at most two transactions. You may not engage in multiple transactions 
 *  at the same time (ie, you must sell the stock before you buy again).
 * 
 * Example:
 * Given an example [4,4,6,1,1,4,2,5], return 6.
 * 
 * @author Vlad Manolache
 */
public class BuySellStocks {
    
    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        System.out.println(Arrays.toString(prices));    

        // max profit from left side
        int n = prices.length;
        int[] left = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        System.out.println(Arrays.toString(left));    

        // max profit from right side
        int[] right = new int[n];
        int max = prices[n - 1];
        for (int i = n - 2; i > 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        System.out.println(Arrays.toString(right));    
 
        // find the maximum profit.
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit; 
    }
    
}
