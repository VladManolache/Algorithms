
package algorithms.graph.dfs;

import algorithms.graph.bfs.BreadthFirstSearch;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vmanolache
 */
public class BreathFirstSearchTest {
      
    @Test
    public void unidirectionalGraphTest() {
        BreadthFirstSearch bfsSearch = new BreadthFirstSearch();
        int[] result = bfsSearch.search("C:\\Users\\vmanolache\\Documents\\NetBeansProjects\\Algorithms\\test\\algorithms\\graph\\adjList2.txt", 1, false);
        
        assertArrayEquals(result, new int[]{0, 1, 2, 3, 5, 4, 6, 10, 7, 9, 11, 8, 12});
    }
    
    @Test
    public void bidirectionalGraphTest() {
        BreadthFirstSearch bfsSearch = new BreadthFirstSearch();
        int[] result = bfsSearch.search("C:\\Users\\vmanolache\\Documents\\NetBeansProjects\\Algorithms\\test\\algorithms\\graph\\adjList2.txt", 1, true);

        assertArrayEquals(result, new int[]{0, 1, 2, 3, 5, 4, 6, 10, 7, 11, 8, 9, 12});
    }
}
