
package algorithms.graph.search;
 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vmanolache
 */
public class DepthFirstSearchTest {
      
    @Test
    public void unidirectionalGraphTest() {
        DepthFirstSearch dfsSearch = new DepthFirstSearch("C:\\Users\\vmanolache\\Documents\\NetBeansProjects\\Algorithms\\test\\algorithms\\graph\\adjList2.txt", false);
        int[] result = dfsSearch.search(1);
        
        assertArrayEquals(result, new int[]{0, 1, 2, 5, 3, 4, 6, 7, 8, 9, 10, 11, 12});
    }
    
    @Test
    public void bidirectionalGraphTest() {
        DepthFirstSearch dfsSearch = new DepthFirstSearch("C:\\Users\\vmanolache\\Documents\\NetBeansProjects\\Algorithms\\test\\algorithms\\graph\\adjList2.txt", true);
        int[] result = dfsSearch.search(1);
         
        assertArrayEquals(result, new int[]{0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12, 3, 4});
    }
}
