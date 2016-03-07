package algorithms.trees;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class BinarySearchTreeTest {

    @Test
    public void mainTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

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
    public void mainInsertionTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

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
        
        assertEquals(binarySearchTree.rootNode.value, 5);
        assertEquals(binarySearchTree.rootNode.leftChild.value, 3);
        assertEquals(binarySearchTree.rootNode.leftChild.leftChild.value, 1);
        assertEquals(binarySearchTree.rootNode.rightChild.value, 7);
        assertEquals(binarySearchTree.rootNode.rightChild.leftChild.value, 6);
    }
}
