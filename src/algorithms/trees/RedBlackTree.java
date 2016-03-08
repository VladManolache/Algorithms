/**
 * Implementation of RedBlackTree data structure.
 * https://www.cs.auckland.ac.nz/software/AlgAnim/red_black.html
 */
package algorithms.trees;

import algorithms.trees.RBNode.NodeColor;

/**
 *
 * @author Vlad Manolache
 */
public class RedBlackTree {
  
    RBNode rootNode;  // Root node of binary tree.

    public RBNode getRootNode() {
        return rootNode;
    }
    
    public RBNode insert(int value) {
        if (rootNode == null) {
            rootNode = new RBNode(value);
            return rootNode;
        }

        RBNode node = rootNode;
        while (true) {
            if (value < node.value) {
                if (node.leftChild == null) {
                    node.leftChild = new RBNode(value);
                    node.leftChild.parent = node;
                    return node.leftChild;
                }
                node = node.leftChild;
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new RBNode(value);
                    node.rightChild.parent = node;
                    return node.rightChild;
                }
                node = node.rightChild;
            }
        }
    }
    
    public void insertNode(int value) {
        /* Insert in the tree in the usual way */
        RBNode x = insert(value);
        RBNode y;

        /* Now restore the red-black property */
        x.color = NodeColor.RED;
        while ((x != rootNode) && (x.parent.color == NodeColor.RED)) {

            if (x.parent == x.parent.parent.leftChild) {
                /* If x's parent is a left, y is x's right 'uncle' */
                y = x.parent.parent.rightChild;
                if (y!= null && y.color == NodeColor.RED) {
                    /* case 1 - change the colours */
                    x.parent.color = NodeColor.BLACK;
                    y.color = NodeColor.BLACK;
                    x.parent.parent.color = NodeColor.RED;

                    /* Move x up the tree */
                    x = x.parent.parent;
                } else {
                    /* y is a black node */
                    if (x == x.parent.rightChild) {
                        /* and x is to the right */
                        
                        /* case 2 - move x up and rotate */
                        x = x.parent;
                        leftRotate(x);
                    }
                    /* case 3 */
                    x.parent.color = NodeColor.BLACK;
                    x.parent.parent.color = NodeColor.RED;
                    rightRotate(x.parent.parent);
                }
            } else {
                y = x.parent.parent.leftChild;
                if (y!= null && y.color == NodeColor.RED) {
                    /* case 1 - change the colours */
                    x.parent.color = NodeColor.BLACK;
                    y.color = NodeColor.BLACK;
                    x.parent.parent.color = NodeColor.RED;

                    /* Move x up the tree */
                    x = x.parent.parent;
                } else {
                    /* y is a black node */
                    if (x == x.parent.leftChild) {  
                        /* case 2 - move x up and rotate */
                        x = x.parent;
                        rightRotate(x);
                    }
                    /* case 3 */
                    x.parent.color = NodeColor.BLACK;
                    x.parent.parent.color = NodeColor.RED;
                    leftRotate(x.parent.parent);
                }
            }
        }
        
        /* Colour the root black */
        rootNode.color = NodeColor.BLACK;
    }
    
    public void leftRotate(RBNode x) {
        RBNode y = x.rightChild;
 
        /* Turn y's left sub-tree into x's right sub-tree */
        x.rightChild = y.leftChild;
        if (y.leftChild != null) {
            y.leftChild.parent = x;
        }

        /* y's new parent was x's parent */
        y.parent = x.parent;

        /* Set the parent to point to y instead of x */
        /* First see whether we're at the root */
        if (x.parent == null) {
            this.rootNode = y;
        } else if (x == x.parent.leftChild) {
            /* x was on the left of its parent */
            x.parent.leftChild = y;
        } else {
            /* x must have been on the right */
            x.parent.rightChild = y;
        }

        /* Finally, put x on y's left */
        y.leftChild = x;
        x.parent = y;
    }
    
    public void rightRotate(RBNode x) {
        RBNode y = x.leftChild;
  
        x.leftChild = y.rightChild;
        if (y.rightChild != null) {
            y.rightChild.parent = x;
        }

        /* y's new parent was x's parent */
        y.parent = x.parent;

        /* Set the parent to point to y instead of x */
        /* First see whether we're at the root */
        if (x.parent == null) {
            this.rootNode = y;
        } else if (x == x.parent.rightChild) {
            /* x was on the left of its parent */
            x.parent.rightChild = y;
        } else {
            /* x must have been on the right */
            x.parent.leftChild = y;
        }

        /* Finally, put x on y's left */
        y.rightChild = x;
        x.parent = y;
    }

    public int treeHeigh(RBNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(1 + treeHeigh(node.leftChild), 1 + treeHeigh(node.rightChild));
    }
    
    public int treeCountInternal(RBNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + treeCountInternal(node.leftChild) + treeCountInternal(node.rightChild);
    }
    
    public void inorderTraversal(RBNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.leftChild);
        
        System.out.print(root.value + " ");

        inorderTraversal(root.rightChild);
    }
}
