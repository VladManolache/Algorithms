/*
 * Implementation of depth first search.
 */
package algorithms.graph.search;

import algorithms.graph.ALGraph;

/**
 *
 * @author vmanolache
 */
public class DepthFirstSearch {
    
    ALGraph graph;
    int[] visited;    
    int[] result;
    int k;
    
    public DepthFirstSearch(String fileName, boolean directionalGraph) {
        // Initialise the graph.
        graph = new ALGraph(fileName, directionalGraph);
        result = new int[graph.N + 1];
        visited = new int[graph.N + 1];
        
        // Initially, all nodes are unvisited.
        k = 0; 
        for (int i = 1; i < visited.length; i++) {
            visited[i] = 0;
        }
    }
    
    public int[] search(int startElement) { 
        dfs(graph, startElement);
        
        return result;
    }
    
    public void dfs(ALGraph graph, int currentElement) {
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
