package algorithms.data_structure.trees.bst.balanced;

import algorithms.data_structure.trees.bst.common.BSTNode;

/**
 *
 * @author Vlad Manolache
 */
public class BSTBalanced {
    
    public BSTNode root;
    
    private boolean isBalanced(BSTNode node) {
        
        if ( node == null ) {
            return true;
        }
        
        int lh = height(node.leftChild);
        int rh = height(node.rightChild);

        return Math.abs(lh - rh) <= 1 &&
                isBalanced(node.leftChild) &&
                isBalanced(node.rightChild);
    }
    
    private int height(BSTNode node) {
        if (node == null) {
            return 0;
        }
        
        int lh = height(node.leftChild);
        int rh = height(node.rightChild);
        return 1 + (lh > rh ? lh : rh);
    }
    
    public boolean isBalanced() {
        if ( isBalanced(root) ) {
            System.out.println("Tree is balanced");
            return true;
        }
        else {
            System.out.println("Tree is not balanced");
            return false;
        }
    }
}
