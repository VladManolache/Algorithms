/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.math;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class FactorialGeneratorTest {
    
    @Test
    void mainTest() {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assert(factorialCalculator.calculateFactorial(7) == 5040);
    }
    
}
