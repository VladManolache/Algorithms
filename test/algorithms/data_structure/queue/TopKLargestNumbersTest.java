package algorithms.data_structure.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class TopKLargestNumbersTest {
    
    @Test
    void mainTest() {
        TopKLargestNumbers topKLargestNumbers = new TopKLargestNumbers(3);
        topKLargestNumbers.add(10);
        topKLargestNumbers.add(15);
        topKLargestNumbers.add(5);
        topKLargestNumbers.add(7);
        topKLargestNumbers.add(2); 
        topKLargestNumbers.add(12);
        topKLargestNumbers.add(19);
        
        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(19);
        expectedResult.add(15);
        expectedResult.add(12);

        assert(topKLargestNumbers.topK().equals(expectedResult));
    }
    
}
