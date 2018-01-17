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
package algorithms.other;

import algorithms.other.RedWhiteBlueNode.Color;

/**
 *
 * @author Vlad Manolache
 */
public class RedWhiteBlueSort {
    
    public void sortElements(RedWhiteBlueNode[] array) {
        int red = 0;  // Pointer to last red value.
        int blue = array.length - 1;  // Pointer to first blue value.
        int current = 0;  // Current pointer.
        
        /**
         * The idea is to keep pointers to the last red element and first blue element.
         * Iterate over all elements, and move red elements to left and blue elements to right.
         */
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
    
    public void swap(RedWhiteBlueNode a, RedWhiteBlueNode b) {
        Color tmp = a.getColor();
        a.setColor(b.getColor());
        b.setColor(tmp);
    }
}
