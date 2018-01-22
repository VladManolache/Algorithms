/*
 * Implementation of breadth first search.
 */
package algorithms.data_structure.graph.search;

import algorithms.data_structure.graph.common.ALGraph;
import java.util.LinkedList;
import java.util.Queue; 

/**
 *
 * @author vmanolache
 */
public class BreadthFirstSearch {
    
    public int[] search(String fileName, int startElement, boolean directionalGraph) {
        
        // Initialise the graph.
        ALGraph graph = new ALGraph(fileName, directionalGraph);
        
        // Initially, all nodes are unvisited.
        int[] visited = new int[graph.N + 1];
        int[] result = new int[graph.N + 1];
        for (int i = 1; i < visited.length; i++) {
            visited[i] = 0;
        }
        
        // Enque the first element.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startElement);
        
        int k = 0;
        int currentElement;
        int[] currentAdjList;
        while (!queue.isEmpty()) {
            currentElement = queue.remove();  
            
            // If the element dequed is not visited, mark it as visited and 
            // add all it's children to the queue.
            if (visited[currentElement] == 0) {
                visited[currentElement] = 1;
                result[++k] = currentElement;
                currentAdjList = graph.getAdjacencyList(currentElement);
                for (int i = 0; i < currentAdjList.length; i++) {
                    queue.add(currentAdjList[i]);
                }
            } 
        }
        
        return result;
    }
    
}
