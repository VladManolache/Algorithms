package algorithms.data_structure.array.quickselect;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class KThLargestTest {
    
    @Test
    void testSimple() {
        int[] nums = {1, 2, 3, 4, 5};
        KThLargest kLargest = new KThLargest();
        
        assert(kLargest.kthElement(1, nums) == 5); 
    }
    
    @Test
    void testKthLargest() {
        int[] nums = {9, 3, 2, 4, 8};
        KThLargest kLargest = new KThLargest();
        
        assert(kLargest.kthElement(3, nums) == 4);
    }
    
}
