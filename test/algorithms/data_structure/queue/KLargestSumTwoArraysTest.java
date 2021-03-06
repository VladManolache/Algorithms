package algorithms.data_structure.queue;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class KLargestSumTwoArraysTest {
    
    @Test
    void mainTest() {
        int[] array1 = new int[] {1, 7, 11}; 
        int[] array2 = new int[] {2, 4, 6};
        KLargestSumTwoArrays kLargestSumTwoArrays = new KLargestSumTwoArrays(8);
        System.out.println(kLargestSumTwoArrays.kLargestSum(array1, array2));
    }
    
}
