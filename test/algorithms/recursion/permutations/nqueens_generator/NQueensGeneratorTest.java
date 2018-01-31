/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursion.permutations.nqueens_generator;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class NQueensGeneratorTest {
    
    @Test
    void mainTest() {
        NQueensGenerator nQueensGenerator = new NQueensGenerator();
        int count = nQueensGenerator.generateNQueens(8);
        assert(count == 92);
    }
    
}
