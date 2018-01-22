/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.search.binary;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class SqrtXTest {
    
    @Test
    void test100() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.getSqrt(100) == 10);
    }
    
    @Test
    void test225() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.getSqrt(225) == 15);
    }
}
