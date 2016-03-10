
package algorithms.sorting;
 
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad Manolache
 */
public class QuickSortTest {
    
    int[] numbers;
    int SIZE = 100000;
    int MAX_NUMBER = 1000;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX_NUMBER);
        }
    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();
 
        QuickSort sorter = new QuickSort();
        sorter.executeSort(numbers, false); 
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("V1-Quicksort " + elapsedTime + " ms");

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true); 
    }
    
    @Test
    public void testRandomizedQuickSort() {
        long startTime = System.currentTimeMillis();
 
        QuickSort sorter = new QuickSort();
        sorter.executeSort(numbers, true); 
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("V2-Quicksort " + elapsedTime + " ms");

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true); 
    }
}
