package algorithms.queue;

import java.util.Collections;
import java.util.Comparator;
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
    
    final private int k;
    
    /**
     * A binary tree is min-ordered if the key in each node is smaller 
     *  than (or equal to) the keys in the two children nodes (if any).
     */
    final private Queue<Integer> minPrioirtyQueue;
    
    public TopKLargestNumbers(int k) {
        this.k = k;
         
        minPrioirtyQueue = new PriorityQueue<>(k);
    }
    
    public void add(int number) {
        System.out.println(number);
        if (minPrioirtyQueue.size() < k) {
            minPrioirtyQueue.add(number);
        }
        else if (number > minPrioirtyQueue.peek()) {
            minPrioirtyQueue.remove();
            minPrioirtyQueue.add(number); 
        } 
        
        System.out.println(minPrioirtyQueue);
    }
    
    public int topK() {
        return minPrioirtyQueue.peek();
    }
}
