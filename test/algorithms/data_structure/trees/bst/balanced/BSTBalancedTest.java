package algorithms.data_structure.trees.bst.balanced;
 
import algorithms.data_structure.trees.bst.common.BST;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Vlad Manolache
 */
public class BSTBalancedTest {

    @Test
    void mainTest() {
        BST binarySearchTree = new BST();

        // Add values to binary search tree.
        ArrayList<Integer> values = new ArrayList<>();
        values.add(25);
        values.add(175);
        values.add(150);
        values.add(100);
        values.add(125);
        for (int i = 0; i < values.size(); i++) {
            binarySearchTree.insert(values.get(i));
        }

        binarySearchTree.preorderTraversal(binarySearchTree.getRootNode());

        binarySearchTree.removeNode(25);
        binarySearchTree.removeNode(175);

        System.out.println();
        binarySearchTree.preorderTraversal(binarySearchTree.getRootNode());
        System.out.println();
    }
    
    @Test
    void mainInsertionTest() {
        BST binarySearchTree = new BST();

        // Add values to binary search tree.
        ArrayList<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(3);
        values.add(7);
        values.add(1);
        values.add(6);
        for (int i = 0; i < values.size(); i++) {
            binarySearchTree.insert(values.get(i));
        }
        
        assertEquals(binarySearchTree.getRootNode().value, 5);
        assertEquals(binarySearchTree.getRootNode().leftChild.value, 3);
        assertEquals(binarySearchTree.getRootNode().leftChild.leftChild.value, 1);
        assertEquals(binarySearchTree.getRootNode().rightChild.value, 7);
        assertEquals(binarySearchTree.getRootNode().rightChild.leftChild.value, 6);
    }
    
    @Test
    void heightTest() {
        BST binarySearchTree = new BST();

        // Add values to binary search tree.
        for (int i = 0; i < 100; i++) {
            binarySearchTree.insert(i);
        }
         
        System.out.println("Height = " + binarySearchTree.treeHeigh(binarySearchTree.getRootNode()));
        assertEquals(100, binarySearchTree.treeHeigh(binarySearchTree.getRootNode()));
    }
}
