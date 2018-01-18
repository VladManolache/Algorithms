package algorithms.sort;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


/**
 *
 * @author Vlad Manolache
 */
public class QuickSortTest {
    
    int[] numbers;
    int SIZE = 100000;
    int MAX_NUMBER = 1000;

    @BeforeEach
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX_NUMBER);
        }
    }
 
    @Test
    public void testQuickSortV1() {
        long startTime = System.currentTimeMillis();
 
        QuickSort sorter = new QuickSort();
        sorter.executeSort(numbers, true); 
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("V1 - Quicksort " + elapsedTime + " ms");

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true); 
    }
    
    @Test
    public void testQuickSortV1WorstCase() {
        long startTime = System.currentTimeMillis();
 
        int[] numbersWorstCase = new int[SIZE];   // Fails on larger values.
        for (int i = 0; i < numbersWorstCase.length; i++) {
            numbersWorstCase[i] = i;
        }
        
        QuickSort sorter = new QuickSort();
        sorter.executeSort(numbersWorstCase, true); 
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("V1 - Quicksort on sorted array " + elapsedTime + " ms");

        for (int i = 0; i < numbersWorstCase.length - 1; i++) {
            if (numbersWorstCase[i] > numbersWorstCase[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true); 
    }
    
    @Test
    public void testQuickSortV2() {
        long startTime = System.currentTimeMillis();
 
        QuickSort sorter = new QuickSort();
        sorter.executeSort(numbers, false); 
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("V2 - Quicksort " + elapsedTime + " ms");

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true); 
    }
    
    @Test
    public void testQuickSortV2WorstCase() {
        long startTime = System.currentTimeMillis();
 
        // Warning - Having an array of 100000 elements produces a stack overflow error.
        int[] numbersWorstCase = new int[1000];
        for (int i = 0; i < numbersWorstCase.length; i++) {
            numbersWorstCase[i] = i;
        }
        
        QuickSort sorter = new QuickSort();
        sorter.executeSort(numbersWorstCase, false); 
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("V2 - Quicksort on sorted array " + elapsedTime + " ms");

        for (int i = 0; i < numbersWorstCase.length - 1; i++) {
            if (numbersWorstCase[i] > numbersWorstCase[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true); 
    }
}
