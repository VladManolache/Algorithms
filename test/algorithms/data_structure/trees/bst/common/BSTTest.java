package algorithms.data_structure.trees.bst.common;


import algorithms.data_structure.trees.bst.balanced.BSTBalanced;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class BSTTest {
  
    @Test
    void testBalancedTree() {
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
    void testNonBalancedTree() {
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
