/**
 * Implementation of binary search tree data structure.
 */
package algorithms.trees;
 
/**
 *
 * @author Vlad Manolache
 */
public class BinarySearchTree {

    BSTNode rootNode;  // Root node of binary tree.

    public BSTNode getRootNode() {
        return rootNode;
    }
    
    public void addNode(int value) {
        if (rootNode == null) {
            rootNode = new BSTNode(value);
            return;
        }

        BSTNode node = rootNode;
        while (true) {
            if (value < node.value) {
                if (node.leftChild == null) {
                    node.leftChild = new BSTNode(value);
                    break;
                }
                node = node.leftChild;
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new BSTNode(value);
                    break;
                }
                node = node.rightChild;
            }
        }
    }

    public boolean removeNode(int value) {
        if (rootNode == null) {  
            return false;
        } 
        // If the root node is the node we want to rempve, add a temporary node as root of the tree.
        // Remove the previous root node, then change the root of the tree.
        // This is done to avoid handling the cases where we have no root node.
        else if (rootNode.value == value) {  
            BSTNode auxRoot = new BSTNode(0);
            auxRoot.leftChild = rootNode;
            boolean result = rootNode.remove(value, auxRoot);
            rootNode = auxRoot.leftChild;
            return result;
        }
        // The 
        else {
            return rootNode.remove(value, null);
        }
    }

    /**
     * Binary Tree traversals *
     * @param root - Root node
     */
    public void preorderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");

        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);
    }

    public void inorderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        preorderTraversal(root.leftChild);
        System.out.print(root.value + " ");
        preorderTraversal(root.rightChild);
    }

    public void postorderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);
        System.out.print(root.value + " ");
    } 
}
