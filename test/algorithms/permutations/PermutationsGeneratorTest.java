package algorithms.permutations;

import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class PermutationsGeneratorTest {

    @Test
    public void mainTest() {
        PermutationsGenerator logic = new PermutationsGenerator();
        logic.permute("abcdefg");
    }
}
