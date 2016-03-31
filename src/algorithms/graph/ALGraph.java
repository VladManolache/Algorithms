/*
 * Implementation of a graph data structure using an adjaceny list.
 */
package algorithms.graph;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vmanolache
 */
public class ALGraph {

    private static final String NEWLINE = System.getProperty("line.separator");

    public int N, E;
    Map<Integer, List<AdjacencyListElement>> adjacencyList = new HashMap<>();

    public ALGraph(String inputFile, boolean directionalGraph) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = br.readLine();

            String[] nodeNames = line.split(" ");
            N = Integer.parseInt(nodeNames[0]);
            E = Integer.parseInt(nodeNames[1]);

            // Initialize adjacency list.
            for (int i = 1; i <= N; i++) {
                adjacencyList.put(i, new ArrayList<AdjacencyListElement>());
            }
            
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                int v1 = Integer.parseInt(tokens[0]);
                int v2 = Integer.parseInt(tokens[1]); 

                // we add neighbor to each node in both directions.
                addNeighbor(v1, v2);
                if (!directionalGraph) {
                    addNeighbor(v2, v1);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Integer key : adjacencyList.keySet()) {
            s.append(key).append(": ");
            for (AdjacencyListElement w : adjacencyList.get(key)) {
                s.append(w.node2).append(" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public int[] getAdjacencyList(int node) {
        int[] list = new int[adjacencyList.get(node).size()];
        for (int i = 0; i < adjacencyList.get(node).size(); i++) {
            list[i] = adjacencyList.get(node).get(i).node2;
        }
        return list;
    }
    
    private void addNeighbor(int v1, int v2) {
        adjacencyList.get(v1).add(new AdjacencyListElement(v1, v2));
    }
}
