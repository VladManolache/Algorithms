package algorithms.queue;

import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class TopKLargestNumbersTest {
    
    @Test
    public void mainTest() {
        TopKLargestNumbers topKLargestNumbers = new TopKLargestNumbers(3);
        topKLargestNumbers.add(10);
        topKLargestNumbers.add(15);
        topKLargestNumbers.add(5);
        topKLargestNumbers.add(7);
        topKLargestNumbers.add(2); 
        topKLargestNumbers.add(12);
        topKLargestNumbers.add(19);
        
        assert(topKLargestNumbers.topK() == 12);
    }
    
}
