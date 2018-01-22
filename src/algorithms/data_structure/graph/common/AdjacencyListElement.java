/*
 * Adjacency list element.
 */
package algorithms.data_structure.graph.common;

/**
 *
 * @author Vlad Manolache
 */
public class AdjacencyListElement { 
    public int node1;
    public int node2;
    public int cost;
    
    public AdjacencyListElement (int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
    
    public AdjacencyListElement (int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }
}
