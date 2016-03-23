/*
 * Implementation of depth first search.
 */
package algorithms.graph.bfs;

import algorithms.graph.ALGraph;

/**
 *
 * @author vmanolache
 */
public class DepthFirstSearch {
    
    int[] visited;    
    int[] result;
    int k;
    
    public int[] search(String fileName, int startElement, boolean directionalGraph) {
        
        // Initialise the graph.
        ALGraph graph = new ALGraph(fileName, directionalGraph);
        
        // Initially, all nodes are unvisited.
        k = 0;
        result = new int[graph.N + 1];
        visited = new int[graph.N + 1];
        for (int i = 1; i < visited.length; i++) {
            visited[i] = 0;
        }
        
        dfs(graph, startElement);
        
        return result;
    }
    
    private void dfs(ALGraph graph, int currentElement) {
        visited[currentElement] = 1;
        
        result[++k] = currentElement; 
        
        int[] currentAdjList = graph.getAdjacencyList(currentElement);
        for (int i = 0; i < currentAdjList.length; i++) {
            if (visited[currentAdjList[i]] == 0) {
                dfs(graph, currentAdjList[i]);
            }
        }
    }
}
