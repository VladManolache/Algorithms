/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.math;

/**
 *
 * @author user
 */
public class FactorialCalculator {
    
    public int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n * calculateFactorial(n - 1);
        }
    }
    
}
