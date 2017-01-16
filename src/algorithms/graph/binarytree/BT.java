/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph.binarytree;

/**
 *
 * @author user
 */
public class BT {
    
    public Node root;
    
    public boolean isBalanced(Node node) {
        
        if ( node == null ) {
            return true;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        if (Math.abs(lh - rh) <= 1 && 
                isBalanced(node.left) && 
                isBalanced(node.right)) {
            return true;
        }
        
        return false;
    }
    
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        return 1 + (lh > rh ? lh : rh);
    }
    
    public boolean isBalanced() {
        if (isBalanced(root)) {
            System.out.println("Tree is balanced");
            return true;
        }
        else {
            System.out.println("Tree is not balanced");
            return false;
        }
    }
}
