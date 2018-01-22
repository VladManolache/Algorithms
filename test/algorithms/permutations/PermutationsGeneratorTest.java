package algorithms.permutations;

import algorithms.math.FactorialCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class PermutationsGeneratorTest {

    @Test
    void mainTest_v1() {
        PermutationsGenerator logic = new PermutationsGenerator();
        logic.generatePermutations_v1("abcdefg");
    }
    
    @Test
    void mainTest_v2() {
        String string = "abcdefg";
        PermutationsGenerator permutationsGenerator = new PermutationsGenerator();
        ArrayList<String> result = permutationsGenerator.generatePermutations_v2(string);
         
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assert(result.size() == factorialCalculator.calculateFactorial(string.length()));
    }
}
