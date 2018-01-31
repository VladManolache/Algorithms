package algorithms.recursion.permutations.permutations_generator;

import algorithms.math.FactorialCalculator;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 *
 * @author Vlad Manolache
 */
public class PermutationsGeneratorTest {

    @Test
    void mainTest_v1() {
        String string = "abcd";
        PermutationsGenerator permutationsGenerator = new PermutationsGenerator();
        Set<String> result = permutationsGenerator.generatePermutations_v1(string);

        Set<String> result1 = permutationsGenerator.generatePermutations_v2(string);
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assert(result.size() == factorialCalculator.calculateFactorial(string.length()));
        assert(result.equals(result1));
    }

    @Test
    void mainTest_v2() {
        String string = "abcdefgh";
        PermutationsGenerator permutationsGenerator = new PermutationsGenerator();
        Set<String> result = permutationsGenerator.generatePermutations_v1(string);

        Set<String> result1 = permutationsGenerator.generatePermutations_v2(string);
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assert(result.size() == factorialCalculator.calculateFactorial(string.length()));
        assert(result.equals(result1));
    }
}
