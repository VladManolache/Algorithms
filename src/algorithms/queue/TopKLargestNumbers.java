package algorithms.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implement a data structure, provide two interfaces:
 * - add(number): Add a new number in the data structure.
 * - topK(): Return the top k largest numbers in this data structure. 
 *  k is given when we create the data structure.
 *  
 * @author Vlad Manolache
 */
public class TopKLargestNumbers {
    
    /**
     * Number of elements that should be returned.
     */
    final private int k;
    
    /**
     * A binary tree is min-ordered if the key in each node is smaller 
     *  than (or equal to) the keys in the two children nodes (if any).
     */
    final private Queue<Integer> minPriorityQueue;
    
    public TopKLargestNumbers(int k) {
        this.k = k;
         
        // use the default element ordering to make this a minPriorityQueue.
        minPriorityQueue = new PriorityQueue<>(k);
    }
    
    public void add(int number) {
        System.out.println(number);
        
        // use the min priority queue to store the K largest elements. 
        if (minPriorityQueue.size() < k) {
            minPriorityQueue.add(number);
        }
        else if (number > minPriorityQueue.peek()) {
            minPriorityQueue.remove();
            minPriorityQueue.add(number); 
        } 
        
        System.out.println(minPriorityQueue);
    }
    
    public List<Integer> topK() {
        List<Integer> result = new ArrayList<>();
        for (int x : minPriorityQueue) {
            result.add(x);
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
