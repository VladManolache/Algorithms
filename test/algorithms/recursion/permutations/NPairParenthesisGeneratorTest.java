/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursion.permutations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class NPairParenthesisGeneratorTest {
    
    @Test
    void mainTest_v2() {
        NPairParenthesisGenerator nPairParenthesisGenerator = new NPairParenthesisGenerator();
        ArrayList<String> validPermutations = nPairParenthesisGenerator.buildValidPermutations(3);
        assert(validPermutations.size() == 5);
    }
    
}
