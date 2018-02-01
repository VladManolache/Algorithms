/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.search.binary.sqrtx;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class SqrtXTest {

    @Test
    void test2() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.sqrt_iterative(2) == 1);
        assert(sqrtX.sqrt_recursive(2) == 1);
    }


    @Test
    void test6() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.sqrt_iterative(6) == 2);
        assert(sqrtX.sqrt_recursive(6) == 2);
    }

    @Test
    void test100() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.sqrt_iterative(100) == 10);
        assert(sqrtX.sqrt_recursive(100) == 10);
    }
    
    @Test
    void test225() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.sqrt_iterative(225) == 15);
        assert(sqrtX.sqrt_recursive(225) == 15);
    }

    @Test
    void test46656() {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.sqrt_iterative(46340) == 215);
        assert(sqrtX.sqrt_recursive(46340) == 215);
    }
}
