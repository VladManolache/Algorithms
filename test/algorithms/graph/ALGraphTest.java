
package algorithms.graph;

import org.junit.Test;

/**
 *
 * @author vmanolache
 */
public class ALGraphTest {
       
    @Test
    public void mainTest() {
        ALGraph graph = new ALGraph("C:\\Users\\vmanolache\\Documents\\NetBeansProjects\\Algorithms\\test\\algorithms\\graph\\adjList2.txt", false);
        System.out.println(graph.toString());
    }
}
