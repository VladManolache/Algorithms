package algorithms.sequences;

import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class BuySellStocksTest {
    
    @Test
    public void mainTest() {
        int[] values = {4, 4, 6, 1, 1, 4, 2, 5};
        
        BuySellStocks buySellStocks = new BuySellStocks();
        assert( buySellStocks.getMaxProfit(values) == 6);
    }
    
}
