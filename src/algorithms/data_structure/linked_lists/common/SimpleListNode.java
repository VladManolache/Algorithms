
/**
 * Representation of simple linked list node.
 */

package algorithms.data_structure.linked_lists.common;

/**
 *
 * @author Vlad Manolache
 */
public class SimpleListNode {
    int value;
    SimpleListNode nextNode;
    
    public SimpleListNode(int value, SimpleListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
    
    /** Getters **/
    
    public int getValue() {
        return value;
    }
    
    public SimpleListNode getNextNode() {
        return nextNode;
    }
    
    /** Setters **/
    
    public void setNextNode(SimpleListNode nextNode) {
        this.nextNode = nextNode;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
}
