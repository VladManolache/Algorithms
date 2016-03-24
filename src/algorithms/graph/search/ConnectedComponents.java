/*
 * Determine the number of connected components in a given grapth.
 * This implementation uses depth first search.
 */
package algorithms.graph.search; 

/**
 *
 * @author vmanolache
 */
public class ConnectedComponents extends DepthFirstSearch {
      
    public ConnectedComponents(String fileName, boolean directionalGraph) {
       super(fileName, directionalGraph); 
    }
    
    public int connectedComponents() { 
        int connectedComponentsCount = 0;
        for (int i = 1; i <= graph.N; i++) { 
            if (visited[i] == 0) { 
                connectedComponentsCount++;
                dfs(graph, i);
            }
        } 
         
        return connectedComponentsCount;
    }
    
}
