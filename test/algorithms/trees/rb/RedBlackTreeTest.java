/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.rb;
 
import algorithms.trees.rb.RedBlackTree;
import algorithms.trees.rb.RBNode;
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

        assertEquals(1, redBlackTree.getRootNode().value);
        assertEquals(0, redBlackTree.getRootNode().leftChild.value);
        assertEquals(2, redBlackTree.getRootNode().rightChild.value);
        assertEquals(3, redBlackTree.getRootNode().rightChild.rightChild.value); 
        assertEquals(redBlackTree.getRootNode().color, RBNode.NodeColor.BLACK);
        assertEquals(redBlackTree.getRootNode().leftChild.color, RBNode.NodeColor.BLACK);
        assertEquals(redBlackTree.getRootNode().rightChild.color, RBNode.NodeColor.BLACK);
        assertEquals(redBlackTree.getRootNode().rightChild.rightChild.color, RBNode.NodeColor.RED);
    }
    
    @Test
    public void heightTest() {
        RedBlackTree redBlackTree = new RedBlackTree();

        ArrayList<Integer> values = new ArrayList<>(); 
        for (int i = 0; i < 100; i++) {
            redBlackTree.insertNode(i);
        }
        
        System.out.println(redBlackTree.treeHeigh(redBlackTree.getRootNode()));
        System.out.println(2 * Math.log(redBlackTree.treeCountInternal(redBlackTree.getRootNode()))/Math.log(2) + 1);
        assertTrue((redBlackTree.treeHeigh(redBlackTree.getRootNode()) <= 
                2 * Math.log(redBlackTree.treeCountInternal(redBlackTree.getRootNode())) / Math.log(2) + 1));
    }
    
    @Test 
    public void testRotation() {
        RedBlackTree redBlackTree = new RedBlackTree();

        RBNode x = new RBNode('x', RBNode.NodeColor.BLACK);
        RBNode y = new RBNode('y', RBNode.NodeColor.RED);
        y.parent = x;
        x.leftChild = y;
        redBlackTree.setRootNode(x);
        redBlackTree.rightRotate(x);
        assertEquals(redBlackTree.getRootNode(), y);
        assertEquals(redBlackTree.getRootNode().rightChild, x);
        assertEquals(redBlackTree.getRootNode().leftChild, null);
        assertEquals(redBlackTree.getRootNode().rightChild.leftChild, null);
        assertEquals(redBlackTree.getRootNode().rightChild.rightChild, null); 

        redBlackTree.leftRotate(y);

        assertEquals(redBlackTree.getRootNode(), x);
        assertEquals(redBlackTree.getRootNode().leftChild, y);
        assertEquals(redBlackTree.getRootNode().rightChild, null);
        assertEquals(redBlackTree.getRootNode().leftChild.leftChild, null);
        assertEquals(redBlackTree.getRootNode().leftChild.rightChild, null);
    }
}