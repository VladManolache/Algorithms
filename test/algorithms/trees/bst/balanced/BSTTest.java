/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.bst.balanced;

import algorithms.trees.bst.balanced.BSTNode;
import algorithms.trees.bst.balanced.BinarySearchTree;
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
        BinarySearchTree balancedTree = new BinarySearchTree();
        balancedTree.root = new BSTNode(1);
        balancedTree.root.left = new BSTNode(2);
        balancedTree.root.right = new BSTNode(3);
        balancedTree.root.left.left = new BSTNode(4);
        balancedTree.root.left.right = new BSTNode(5);
        balancedTree.root.right.right = new BSTNode(6);
        balancedTree.root.left.left.left = new BSTNode(7);

        assert(balancedTree.isBalanced());
    }
    
    @Test
    public void testNonBalancedTree() {
        BinarySearchTree nonBalancedTree = new BinarySearchTree();
        nonBalancedTree.root = new BSTNode(1);
        nonBalancedTree.root.left = new BSTNode(2);
        nonBalancedTree.root.right = new BSTNode(3);
        nonBalancedTree.root.left.left = new BSTNode(4);
        nonBalancedTree.root.left.right = new BSTNode(5);
        nonBalancedTree.root.right.right = new BSTNode(6);
        nonBalancedTree.root.left.left.left = new BSTNode(7);
        nonBalancedTree.root.left.left.left.left = new BSTNode(8);
        
        assert(!nonBalancedTree.isBalanced());
    }
} 
