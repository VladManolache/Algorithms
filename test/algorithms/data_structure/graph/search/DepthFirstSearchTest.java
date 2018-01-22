
package algorithms.data_structure.graph.search;
 
import algorithms.common.PathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * @author vmanolache
 */
public class DepthFirstSearchTest {
      
    @Test
    void unidirectionalGraphTest() {
        DepthFirstSearch dfsSearch = new DepthFirstSearch(PathUtils.getPath() + "data_structure/graph/search/adjList2.txt", false);
        int[] result = dfsSearch.search(1);
        
        assertArrayEquals(result, new int[]{0, 1, 2, 5, 3, 4, 6, 7, 8, 9, 10, 11, 12});
    }
    
    @Test
    void bidirectionalGraphTest() {
        DepthFirstSearch dfsSearch = new DepthFirstSearch(PathUtils.getPath() + "data_structure/graph/search/adjList2.txt", true);
        int[] result = dfsSearch.search(1);
         
        assertArrayEquals(result, new int[]{0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12, 3, 4});
    }
}
