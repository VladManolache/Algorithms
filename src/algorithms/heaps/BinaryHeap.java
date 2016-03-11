/*
 * Implementation of a binary heap data structure. 
 * More details:
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
 *
 * INFO
 * The heap will be stored as an array. Consider k-th element of the array:
 * - the left child is located at the 2*k index. 
 * - the right child is located at the 2*k+1. index.
 * - the parent is located at the k/2 index.
 * The index 0 is not used in this implementation.
 *
 * Supported operations complexity:
 * Insert – O(log N) 
 * deleteMin – O(log N)  
 * buildHeap – O(N)
 * heapSort - O(N*log N)
 */
package algorithms.heaps;

/**
 *
 * @author Vlad Manolache
 * @param <AnyType> - Type of elements to store.
 */
public class BinaryHeap<AnyType extends Comparable<AnyType>> {

    private static final int INITIAL_CAPACITY = 2;

    int size;
    AnyType[] heap;

    public BinaryHeap() {
        size = 0;
        heap = (AnyType[]) new Comparable[INITIAL_CAPACITY];
    }
    
    public BinaryHeap(AnyType[] array) {
        size = array.length;
        heap = (AnyType[]) new Comparable[array.length + 1];

        System.arraycopy(array, 0, heap, 1, array.length); //we do not use 0 index.

        buildHeap();
    }

    public void insert(AnyType x) {

        // Check if we have reached the maximum nr of elements in the heap.
        if (size == heap.length - 1) {
            doubleSize();
        }

        // Insert a new item to the end of the array.
        int pos = ++size;

        // Percolate new element up by copying the parent elements in the slot
        // of their children and finally set the new element in the appropriate parent slot.
        while (pos > 1 && x.compareTo(heap[pos / 2]) < 0) {
            heap[pos] = heap[pos / 2];
            pos = pos / 2;
        }
        heap[pos] = x;
    }

    public AnyType deleteMin() {
        if (size == 0) {
            throw new RuntimeException();
        }

        AnyType min = heap[1];
        heap[1] = heap[size--];
        percolateDown(1);
        return min;
    }

    public void heapSort(AnyType[] array) {
        size = array.length;
        heap = (AnyType[]) new Comparable[size + 1];
        System.arraycopy(array, 0, heap, 1, size);  // we do not use index 0.
        buildHeap();
        
        // Move the largest element at the end of the heap. Then, re-balance the 
        // heap and decrement the heap size to access the next largest 
        // element in the heap.
        for (int i = size; i > 0; i--) {
            AnyType tmp = heap[i]; // move top item to the end of the heap array.
            heap[i] = heap[1];
            heap[1] = tmp;
            size--;
            percolateDown(1);
        }
        
        for(int k = 0; k < heap.length - 1; k++) {
            array[k] = heap[heap.length - 1 - k];
        }
    }

    /** Utility methods **/
    
    private void buildHeap() {
        for (int k = size / 2; k > 0; k--) {
            percolateDown(k);
        }
    }

    private void percolateDown(int k) {
        AnyType tmp = heap[k];
        int childIndex;

        while (2 * k <= size) {
            childIndex = 2 * k;  // Left child.

            // Compare left child with right child to see which is larger.
            if (childIndex != size && heap[childIndex].compareTo(heap[childIndex + 1]) > 0) {
                childIndex++;
            }

            // Compare parent with either left or right child.
            // If the child is larger, copy the child value over the parent. 
            // Otherwise, if the parent is larger, we stop the search.
            if (tmp.compareTo(heap[childIndex]) > 0) {
                heap[k] = heap[childIndex];
            } else {
                break;
            }

            // Move forward with either the left or right child.
            k = childIndex;
        }

        heap[k] = tmp;
    }

    private void doubleSize() {
        AnyType[] oldHeap = heap;
        heap = (AnyType[]) new Comparable[heap.length * 2];
        System.arraycopy(oldHeap, 1, heap, 1, size);
    }

    @Override
    public String toString() {
        String out = "";
        for (int k = 1; k <= size; k++) {
            out += heap[k] + " ";
        }
        return out;
    }

}
