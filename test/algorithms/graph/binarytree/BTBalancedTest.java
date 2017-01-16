/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph.binarytree;

import org.junit.Test;

/**
 *
 * @author user
 */
public class BTBalancedTest {
  
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
        BT balancedTree = new BT();
        balancedTree.root = new Node(1);
        balancedTree.root.left = new Node(2);
        balancedTree.root.right = new Node(3);
        balancedTree.root.left.left = new Node(4);
        balancedTree.root.left.right = new Node(5);
        balancedTree.root.right.right = new Node(6);
        balancedTree.root.left.left.left = new Node(7);

        assert(balancedTree.isBalanced());
    }
    
    @Test
    public void testNonBalancedTree() {
        BT nonBalancedTree = new BT();
        nonBalancedTree.root = new Node(1);
        nonBalancedTree.root.left = new Node(2);
        nonBalancedTree.root.right = new Node(3);
        nonBalancedTree.root.left.left = new Node(4);
        nonBalancedTree.root.left.right = new Node(5);
        nonBalancedTree.root.right.right = new Node(6);
        nonBalancedTree.root.left.left.left = new Node(7);
        nonBalancedTree.root.left.left.left.left = new Node(8);
        
        assert(!nonBalancedTree.isBalanced());
    }
} 
