package algorithms.data_structure.array.prefixsum;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class BuySellStocksTest {
    
    @Test
    void mainTest() {
        int[] values = {4, 4, 6, 1, 1, 4, 2, 5};
        
        BuySellStocks buySellStocks = new BuySellStocks();
        assert( buySellStocks.getMaxProfit(values) == 6);
    }
    
}
