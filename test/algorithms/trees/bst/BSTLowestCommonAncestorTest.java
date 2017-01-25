/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.bst;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class BSTLowestCommonAncestorTest {
    
    @Test
    public void mainTest() {
        
        // Add values to binary search tree.
        BST tree = new BST();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(4);  // 0
        values.add(3);  // 1
        values.add(7);  // 2
        values.add(5);  // 3
        values.add(6);  // 4
        ArrayList<BSTNode> nodes = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            nodes.add(new BSTNode(values.get(i)));
        }
        tree.setRootNode( nodes.get(0) );
        nodes.get(0).leftChild = nodes.get(1);
        nodes.get(0).rightChild = nodes.get(2);
        nodes.get(2).leftChild = nodes.get(3);
        nodes.get(2).rightChild = nodes.get(4);
        
        BSTLowestCommonAncestor lowestCommonAncestor = new BSTLowestCommonAncestor();
         
        BSTNode result = lowestCommonAncestor.getLowestCommonAncestor(
                tree.getRootNode(), nodes.get(1), nodes.get(3)
        );
        assert(result.value == 4);
        
        result = lowestCommonAncestor.getLowestCommonAncestor(
                tree.getRootNode(), nodes.get(3), nodes.get(4)
        );
        assert(result.value == 7);
        
        result = lowestCommonAncestor.getLowestCommonAncestor(
                tree.getRootNode(), nodes.get(2), nodes.get(4)
        );
        assert(result.value == 7);
    }
}
