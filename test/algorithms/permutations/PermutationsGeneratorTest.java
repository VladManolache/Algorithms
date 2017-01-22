package algorithms.permutations;

import algorithms.math.FactorialCalculator;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class PermutationsGeneratorTest {

    @Test
    public void mainTest_v1() {
        PermutationsGenerator logic = new PermutationsGenerator();
        logic.generatePermutations_v1("abcdefg");
    }
    
    @Test
    public void mainTest_v2() {
        String string = "abcdefg";
        PermutationsGenerator permutationsGenerator = new PermutationsGenerator();
        ArrayList<String> result = permutationsGenerator.generatePermutations_v2(string);
         
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assert(result.size() == factorialCalculator.calculateFactorial(string.length()));
    }
}
