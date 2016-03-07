package algorithms.trees;

import java.util.ArrayList; 
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class BinarySearchTreeTest {
       
     @Test
     public void hello() {
         BinarySearchTree binarySearchTree = new BinarySearchTree(); 
        
        // Add values to binary search tree.
        ArrayList<Integer> values = new ArrayList<>();
        values.add(25);
        values.add(175);
        values.add(150);
        values.add(100);
        values.add(125); 
        for (int i = 0; i < values.size(); i++) {
            binarySearchTree.addNode(values.get(i));
        }

        binarySearchTree.preorderTraversal(binarySearchTree.getRootNode());

        binarySearchTree.removeNode(25);
        binarySearchTree.removeNode(175);

        System.out.println();
        binarySearchTree.preorderTraversal(binarySearchTree.getRootNode()); 
        System.out.println(); 
     }
}
