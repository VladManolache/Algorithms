package algorithms.data_structure.trees.bst.subtree;

import algorithms.data_structure.trees.bst.common.BSTNode;

/**
 * You have two every large binary trees: T1, with millions of nodes, and T2, 
 * with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that 
 * the subtree of n is identical to T2. That is, if you cut off the tree at node n, 
 * the two trees would be identical.
 * 
 * Example:
 * T2 is a subtree of T1 in the following case:
 *         1                 3
 *       /  \               / 
 * T1 = 2   3         T2 = 4
 *         /
 *        4
 * 
 * T2 isn't a subtree of T1 in the following case:
 *        1                3
 *       / \               \
 * T1 = 2  3       T2 =    4
 *        /
 *       4
 * 
 * @author Vlad Manolache
 */
public class BSTSubtree {
    
    public boolean isSubtree(BSTNode tree1, BSTNode tree2) {
        
        if (tree1 == null) {
            return false;
        }
        
        if (tree2 == null) {
            return false;
        }
        
        if (isEqual(tree1, tree2)) {
            return true;
        }
        
        return isSubtree(tree1.leftChild, tree2) || isSubtree(tree1.rightChild, tree2);
    }
    
    private boolean isEqual(BSTNode tree1, BSTNode tree2) {
        if (tree1 == null || tree2 == null) {
            return tree1 == tree2;
        }
        if (tree1.value != tree2.value) {
            return false;
        }
        
        return isEqual(tree1.leftChild, tree2.leftChild) &&
                isEqual(tree1.rightChild, tree2.rightChild);
    }
    
}
