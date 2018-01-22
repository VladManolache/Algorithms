package algorithms.dynamic_programming;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class CoinsInALineTest {
    
    @Test
    void mainTest() {
        CoinsInALine coinsInALine = new CoinsInALine();
        assert(coinsInALine.firstPlayerWins(8));
    }
    
}
