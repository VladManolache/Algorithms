/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.search;

import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author user
 */
public class KClosestNumbersTest {

    @Test
    public void simpleTest() {
        KClosestNumbers kClosestNumbers = new KClosestNumbers();
        String result = Arrays.toString(
                kClosestNumbers.getKClosestNumbers(3, 2, new int[]{1, 2, 3})
        );
        System.out.println(result);
        String expectedResult = Arrays.toString(new int[]{2, 1, 3});
        assert(result.equals(expectedResult));
    }
    
    @Test
    public void mainTest() {
        KClosestNumbers kClosestNumbers = new KClosestNumbers();
        String result = Arrays.toString(
                kClosestNumbers.getKClosestNumbers(3, 2, new int[]{1, 4, 6, 8})
        );
        String expectedResult = Arrays.toString(new int[]{1, 4, 6});
        assert(result.equals(expectedResult));
    }
    
    @Test
    public void complexTest() {
        KClosestNumbers kClosestNumbers = new KClosestNumbers();
        String result = Arrays.toString(
                kClosestNumbers.getKClosestNumbers(4, 35, new int[] {
                    12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56
                })
        );        
        String expectedResult = Arrays.toString(new int[]{35, 39, 30, 42});
        assert(result.equals(expectedResult)); 
    }
    
}
