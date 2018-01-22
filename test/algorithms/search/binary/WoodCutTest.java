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
public class WoodCutTest {
    
    @Test
    void mainTest() {
        int[] values = new int[] {232, 124, 456};
        int k = 7;
        WoodCut woodCut = new WoodCut();
        System.out.println(woodCut.getWoodCut(values, k));
    }
    
}
