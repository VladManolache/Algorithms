package algorithms.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of words and an integer k, return the top k frequent words in the list.
 * 
 * Example:
 * Given
 * [ 
 *   "yes", "lint", "code",
 *   "yes", "code", "baby",
 *   "you", "baby", "chrome",
 *   "safari", "lint", "code",
 *   "body", "lint", "code"
 * ]
 *
 * for k = 3, return ["code", "lint", "baby"].
 * for k = 4, return ["code", "lint", "baby", "yes"]
 * 
 * @author Vlad Manolache
 */
class Pair {
    String s;
    int f;
    public Pair(String inS, int inF) {
        this.s = inS;
        this.f = inF;
    }

    @Override
    public String toString() {
        return "Name:" + s + " count:" + f;
    }
}

public class TopKFrequentWords {
     
    private final Comparator<Pair> pairComparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair a, Pair b) {
            return a.f - b.f;
        }
    };
    
    public List<String> topKFrequentWords(String[] words, int k) {
        
        Queue<Pair> minPriorityQueue = new PriorityQueue<>(k, pairComparator); 
        
        // use a map to find out the nr. of appearences for each word.
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        
        // use the min priority queue to store the most frequent K elements. 
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            if (minPriorityQueue.size() < k) {
                minPriorityQueue.add(pair);
            }
            else if (pairComparator.compare(pair, minPriorityQueue.peek()) > 0)  {
                minPriorityQueue.remove();
                minPriorityQueue.add(pair);
            }
        }
        
        // retrieve the list of K items from the minPriorityQueue.
        List<Pair> tmp = new ArrayList<>();
        for (Pair x : minPriorityQueue) {
            tmp.add(x);
        }
        Collections.sort(tmp, pairComparator);
        Collections.reverse(tmp);
        
        // retrieve results in string format.
        List<String> result = new ArrayList();
        for (Pair pair : tmp) {
            result.add(pair.s);
        }
        
        return result;
    }
    
}
