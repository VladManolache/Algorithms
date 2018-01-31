/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sequences.three_pointers.sort_3colors;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Vlad Manolache
 */
class ThreeColorSortTest {
     
    private static final int SIZE = 100;
 
     @Test
     void mainTest() {
        Color[] nodes = new Color[SIZE];
        Random generator = new Random();
        int currentColor;
        for (int i = 0; i < nodes.length; i++) {
            currentColor = generator.nextInt(3);
            switch (currentColor) {
                case 0:
                    nodes[i] = new Color(Color.Type.RED);
                    break;
                case 1:
                    nodes[i] = new Color(Color.Type.WHITE);
                    break;
                case 2:
                    nodes[i] = new Color(Color.Type.BLUE);
                    break;
                default:
                    break;
            }
        }
        
        ThreeColorSort threeColorSort = new ThreeColorSort();
        threeColorSort.sortElements(nodes);
        
        // Make sore that all nodes are in order.
        for (int i = 0; i < nodes.length - 1; i++) { 
            assertTrue(nodes[i].getColor().compareTo(nodes[i+1].getColor()) <= 0);
        }
     }
}
