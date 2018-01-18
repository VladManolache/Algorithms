/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.permutations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class NPairParanthesisGeneratorTest {
    
    @Test
    public void mainTest_v2() {
        NPairParanthesisGenerator nPairParanthesisGenerator = new NPairParanthesisGenerator();
        ArrayList<String> validPermutations = nPairParanthesisGenerator.buildValidPermutations(3);
        assert(validPermutations.size() == 5);
    }
    
}
