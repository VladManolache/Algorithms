package algorithms.sequences;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class CoinsInALineTest {
    
    @Test
    public void mainTest() {
        CoinsInALine coinsInALine = new CoinsInALine();
        assert(coinsInALine.firstPlayerWins(8) == true);
    }
    
}
