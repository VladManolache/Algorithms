/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursion.permutations;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class RepresentNCentsGeneratorTest {
    
    @Test
    void mainTest_v1() {
        RepresentNCentsGenerator representNCentsGenerator = new RepresentNCentsGenerator();
        assert(representNCentsGenerator.generatePermutations(11) == 4);
    }
}
