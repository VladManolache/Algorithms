package algorithms.trees.bst;

/**
 *
 * @author Vlad Manolache
 */
public class BSTBalanced {
    
    public BSTNode root;
    
    public boolean isBalanced(BSTNode node) {
        
        if ( node == null ) {
            return true;
        }
        
        int lh = height(node.leftChild);
        int rh = height(node.rightChild);
        
        if (Math.abs(lh - rh) <= 1 && 
                isBalanced(node.leftChild) && 
                isBalanced(node.rightChild)) {
            return true;
        }
        
        return false;
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
