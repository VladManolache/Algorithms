
package algorithms.linkedlists.looplocation;

import algorithms.linkedlists.SimpleListNode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad Manolache
 */
public class LoopLocationTest {
     
    
     @Test
     public void hello() {
        SimpleListNode startNode = new SimpleListNode(0, null);
        LoopLocation list = new LoopLocation(startNode);
        
        SimpleListNode node = null;
        for(int i = 1; i < 7; i++) {
            node = new SimpleListNode(i, null);
            list.addNode(node);
        }
        node.setNextNode(startNode.getNextNode().getNextNode());  // Create loop 
                
        assertTrue(list.detectLoopPosition() == 2);
     }
}
