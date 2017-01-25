/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.bst;

import algorithms.trees.bst.BSTBalanced;
import org.junit.Test;

/**
 *
 * @author user
 */
public class BSTTest {
  
    @Test
    public void testBalancedTree() {
        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BSTBalanced balancedTree = new BSTBalanced();
        balancedTree.root = new BSTNode(1);
        balancedTree.root.leftChild = new BSTNode(2);
        balancedTree.root.rightChild = new BSTNode(3);
        balancedTree.root.leftChild.leftChild = new BSTNode(4);
        balancedTree.root.leftChild.rightChild = new BSTNode(5);
        balancedTree.root.rightChild.rightChild = new BSTNode(6);
        balancedTree.root.leftChild.leftChild.leftChild = new BSTNode(7);

        assert(balancedTree.isBalanced());
    }
    
    @Test
    public void testNonBalancedTree() {
        BSTBalanced nonBalancedTree = new BSTBalanced();
        nonBalancedTree.root = new BSTNode(1);
        nonBalancedTree.root.leftChild = new BSTNode(2);
        nonBalancedTree.root.rightChild = new BSTNode(3);
        nonBalancedTree.root.leftChild.leftChild = new BSTNode(4);
        nonBalancedTree.root.leftChild.rightChild = new BSTNode(5);
        nonBalancedTree.root.rightChild.rightChild = new BSTNode(6);
        nonBalancedTree.root.leftChild.leftChild.leftChild = new BSTNode(7);
        nonBalancedTree.root.leftChild.leftChild.leftChild.leftChild = new BSTNode(8);
        
        assert(!nonBalancedTree.isBalanced());
    }
} 
