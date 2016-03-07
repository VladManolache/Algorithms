/**
 * Representation of the binary search tree node.
 */
package algorithms.trees;

/**
 *
 * @author Vlad Manolache
 */
public class BSTNode {

    public BSTNode leftChild;
    public BSTNode rightChild;
    public int value;

    public BSTNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BSTNode(int value, BSTNode leftChild, BSTNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean remove(int value, BSTNode parent) {
        if (value < this.value) {  // Current value is larger.
            if (leftChild != null) {
                return leftChild.remove(value, this);
            } else {
                return false;
            }
        } else if (value > this.value) {  // Current value is smaller.
            if (rightChild != null) {
                return rightChild.remove(value, this);
            } else {
                return false;
            }
        } else {  // Found the value.
            if (leftChild != null && rightChild != null) {  // Has both left and right children.
                this.value = rightChild.minValue();
                rightChild.remove(this.value, this);
            } else if (parent.leftChild == this) {  // Has only a left child.
                parent.leftChild = (leftChild != null) ? leftChild : rightChild;
            } else if (parent.rightChild == this) {  // Has only a right child.
                parent.rightChild = (leftChild != null) ? leftChild : rightChild;
            }
            return true;
        }
    }

    public int minValue() {
        if (leftChild == null) {
            return value;
        } else {
            return leftChild.minValue();
        }
    }
}
