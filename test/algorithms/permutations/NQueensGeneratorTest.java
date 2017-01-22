/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.permutations;

import org.junit.Test;

/**
 *
 * @author user
 */
public class NQueensGeneratorTest {
    
    @Test
    public void mainTest() {
        NQueensGenerator nQueensGenerator = new NQueensGenerator();
        int count = nQueensGenerator.generateNQueens(8);
        assert(count == 92);
    }
    
}
