/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class RedBlackTreeTest {

    @Test
    public void insertionTest() {
        RedBlackTree redBlackTree = new RedBlackTree();

        ArrayList<Integer> values = new ArrayList<>();
        values.add(0);
        values.add(1);
        values.add(2);
        values.add(3); 
        for (int i = 0; i < values.size(); i++) {
            redBlackTree.insertNode(values.get(i));
        }

        assertEquals(1, redBlackTree.rootNode.value);
        assertEquals(0, redBlackTree.rootNode.leftChild.value);
        assertEquals(2, redBlackTree.rootNode.rightChild.value);
        assertEquals(3, redBlackTree.rootNode.rightChild.rightChild.value); 
    }
    
    @Test
    public void heightTest() {
        RedBlackTree redBlackTree = new RedBlackTree();

        ArrayList<Integer> values = new ArrayList<>(); 
        for (int i = 0; i < 100; i++) {
            redBlackTree.insertNode(i);
        }
        
        System.out.println(redBlackTree.treeHeigh(redBlackTree.rootNode));
        System.out.println(2 * Math.log(redBlackTree.treeCountInternal(redBlackTree.rootNode)/Math.log(2) + 1));
        assertTrue((redBlackTree.treeHeigh(redBlackTree.rootNode) <= 
                2 * Math.log(redBlackTree.treeCountInternal(redBlackTree.rootNode) / Math.log(2) + 1)));
    }
}
