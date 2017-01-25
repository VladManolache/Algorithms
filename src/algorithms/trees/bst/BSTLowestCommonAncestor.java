package algorithms.trees.bst;

/**
 *
 * Given the root and two nodes in a Binary Tree. Find the lowest common 
 *  ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is 
 *  the ancestor of both nodes.
 * Assume two nodes are exist in tree.
 * 
 * Example:
 * For the following binary tree:
 *      4
 *     / \
 *    3   7
 *       / \
 *      5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * 
 * @author Vlad Manolache
 */
public class BSTLowestCommonAncestor {
    
    public BSTNode getLowestCommonAncestor(BSTNode root, BSTNode node1, BSTNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        
        BSTNode leftNode = getLowestCommonAncestor(root.leftChild, node1, node2);
        BSTNode rightNode = getLowestCommonAncestor(root.rightChild, node1, node2);
        
        if (leftNode != null && rightNode != null) {
            return root;
        }
        
        if (leftNode != null) {
            return leftNode;
        }
        
        if (rightNode != null) {
            return rightNode;
        }
        
        return null;
    }
    
}
