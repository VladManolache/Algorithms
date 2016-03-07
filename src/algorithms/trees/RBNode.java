
package algorithms.trees;

/**
 *
 * @author Vlad Manolache
 */
public class RBNode {
    
    public RBNode leftChild;
    public RBNode rightChild;
    public RBNode parent;
    public int value;
    public NodeColor color;
     
    public enum NodeColor {
        RED, BLACK 
    } 
     
    public RBNode(int value) { 
        this.value = value;  
        this.color = NodeColor.RED;
    } 
}
