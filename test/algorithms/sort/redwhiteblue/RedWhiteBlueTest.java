/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sort.redwhiteblue;
 
import java.util.Random; 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class RedWhiteBlueTest {
     
    private static final int SIZE = 100;
 
     @Test
     public void mainTest() {
        RedWhiteBlueNode[] nodes = new RedWhiteBlueNode[SIZE];
        Random generator = new Random();
        int currentColor;
        for (int i = 0; i < nodes.length; i++) {
            currentColor = generator.nextInt(3);
            switch (currentColor) {
                case 0:
                    nodes[i] = new RedWhiteBlueNode(RedWhiteBlueNode.Color.RED);
                    break;
                case 1:
                    nodes[i] = new RedWhiteBlueNode(RedWhiteBlueNode.Color.WHITE);
                    break;
                case 2:
                    nodes[i] = new RedWhiteBlueNode(RedWhiteBlueNode.Color.BLUE);
                    break;
                default:
                    break;
            }
        }
        
        RedWhiteBlueSort redWhiteBlueSort = new RedWhiteBlueSort();
        redWhiteBlueSort.sortElements(nodes); 
        
        // Make sore that all nodes are in order.
        for (int i = 0; i < nodes.length - 1; i++) { 
            assertTrue(nodes[i].getColor().compareTo(nodes[i+1].getColor()) <= 0); 
        }
     }
}
