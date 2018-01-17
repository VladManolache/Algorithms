
/** 
 * This method detects the location of a loop in a linked list, if any. 
 */

package algorithms.linkedlists.looplocation;

import algorithms.linkedlists.SimpleListNode;

/**
 *
 * @author Vlad Manolache
 */
public class LoopLocation {
    SimpleListNode start;
    
    public LoopLocation(SimpleListNode start) {
        this.start = start;
    }
    
    public void addNode(SimpleListNode node) {
        SimpleListNode currentNode = this.start;
        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(node);
    }
    
    public void print() {
        SimpleListNode currentNode = this.start;
        while(currentNode.getNextNode() != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }
    
    public int detectLoopPosition() {
        SimpleListNode head = this.start;
        SimpleListNode tail = this.start;
        
        /** 
         * Advance the two pointers at different speeds.
         * Two things can happen: either they meet -> loop or they do not, no loop.
         */ 
        do {
            head = head.getNextNode().getNextNode();
            tail = tail.getNextNode();        
            
        } while(head != null && head.getNextNode() != null && head != tail);
        
        // If there exists a loop, find the position of the loop.
        if (head == tail) {
            
            // Find the size of the loop.
            int count = 0;
            do {
                head = head.getNextNode();
                count++;
            } while(head != tail);
            
            // Move the two pointer count positions apart.
            head = this.start;
            tail = this.start;
            for(int i = 0; i < count; i++) {
                head = head.getNextNode();
            }
            
            // Move both pointers until they meet. This will be the position of the loop.
            while(head != tail) {
                head = head.getNextNode();
                tail = tail.getNextNode();
            }
            
            return head.getValue();
        }
        return -1;
    }
}
