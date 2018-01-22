/*
 * Suppose an array A consists of n elements, each of which is red, white, or blue. 
 * We seek to sort the elements so that all the reds come before all the whites, 
 * which come before all the blues The only operation permitted on the keys are:
 * Examine(A,i) – report the color of the ith element of A.
 * Swap(A,i,j) – swap the ith element of A with the jth element.
 *
 * Find a correct and efficient algorithm for red-white-blue sorting. 
 *
 * There is a linear-time solution.
 */
package algorithms.sequences.two_pointers.sort_3colors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Example:
 * Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
 *
 * Solution:
 * We could use two pointers to solve this question. One pointer is pointing from the front and the
 *  other one is pointing from the back. We swap all 0s to the left of the front pointer and all 2s to the right of
 *  the back pointer, then all 1s would remain in the center.
 *
 * @author Vlad Manolache
 */
public class ThreeColorSort {
    
    public void sortElements(Color[] array) {
        int red = 0;  // Pointer to last red value.
        int blue = array.length - 1;  // Pointer to first blue value.
        int current = 0;  // Current pointer.

        // The idea is to keep pointers to the last red element and first blue element.
        // Iterate over all elements, and move red elements to left and blue elements to right.
        while (current < blue) {
            switch (array[current].getColor()) {
                case RED:
                    swap(array[current], array[red]);
                    red++;
                    current++;
                    break;
                case BLUE:
                    swap(array[current], array[blue]);
                    blue--;
                    break;
                default:
                    current++;
                    break;
            }
        }  
    }  
    
    private void swap(Color a, Color b) {
        Color.Type tmp = a.getColor();
        a.setColor(b.getColor());
        b.setColor(tmp);
    }
}
