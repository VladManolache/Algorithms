
package algorithms.graph;

import algorithms.utils.PathUtils;
import org.junit.Test;

/**
 *
 * @author vmanolache
 */
public class ALGraphTest {
       
    @Test
    public void mainTest() {
        ALGraph graph = new ALGraph(PathUtils.getPath() + "graph/adjList2.txt", false);
        System.out.println(graph.toString());
    }
}
