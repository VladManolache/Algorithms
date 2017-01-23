/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.search;

import org.junit.Test;

/**
 *
 * @author user
 */
public class SqrtXTest {
    
    @Test
    public void test100() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.getSqrt(100) == 10);
    }
    
    @Test
    public void test225() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.getSqrt(225) == 15);
    }
}
