/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.heaps;

import java.util.Arrays; 
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * @author Vlad Manolache 
 */
public class BinaryHeapTest {

    @Test
    public void deleteTest() {
        BinaryHeap<String> h = new BinaryHeap(); 
        h.insert("p");
        h.insert("r");
        h.insert("i");
        h.insert("o");
        System.out.println(h);
        h.deleteMin();
        System.out.println(h);
        assertEquals(h.toString(), "o r p ");
    }
    
    @Test
    public void heapSortTest() { 
        BinaryHeap<Integer> tmp = new BinaryHeap<>();
        Integer[] a = {4,7,7,7,5,0,2,3,5,1};
        tmp.heapSort(a);
        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, new Integer[] {0, 1, 2, 3, 4, 5, 5, 7, 7, 7});
    }
}
