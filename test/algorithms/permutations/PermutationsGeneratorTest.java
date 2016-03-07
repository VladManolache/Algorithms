/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.permutations;

import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class PermutationsGeneratorTest {
     
     @Test
     public void hello() {
        PermutationsGenerator logic = new PermutationsGenerator();
        logic.permute("abcdefg");
     }
}
