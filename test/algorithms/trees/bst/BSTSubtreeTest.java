package algorithms.trees.bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class BSTSubtreeTest {
    
    @Test
    public void isSubtreeTest() {
        
        // Add values to binary search tree.
        BST tree1 = new BST();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(3);
        values.add(7);
        values.add(1);
        values.add(6);
        for (int i = 0; i < values.size(); i++) {
            tree1.insert(values.get(i));
        }
        
        BST tree2 = new BST();
        values = new ArrayList<>();
        values.add(5);
        values.add(3);
        values.add(7);
        values.add(1);
        values.add(6);
        for (int i = 0; i < values.size(); i++) {
            tree2.insert(values.get(i));
        }
        
        BSTSubtree bstSubtree = new BSTSubtree();
        assert(bstSubtree.isSubtree(tree1.getRootNode(), tree2.getRootNode()));
    }
    
    @Test
    public void isNotSubtree() {
        
        // Add values to binary search tree.
        BST tree1 = new BST();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(3);
        values.add(7);
        values.add(1);
        values.add(6);
        for (int i = 0; i < values.size(); i++) {
            tree1.insert(values.get(i));
        }
        
        BST tree2 = new BST();
        values = new ArrayList<>();
        values.add(5);
        values.add(3);
        values.add(7);
        values.add(1); 
        for (int i = 0; i < values.size(); i++) {
            tree2.insert(values.get(i));
        }
        
        BSTSubtree bstSubtree = new BSTSubtree();
        assert(!bstSubtree.isSubtree(tree1.getRootNode(), tree2.getRootNode()));
    }
    
}
