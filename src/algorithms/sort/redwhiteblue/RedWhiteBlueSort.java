/*
 * Suppose an array A consists of n elements, each of which is red, white, or blue. We seek to sort the elements so that all the reds come before all the whites, which come before all the blues The only operation permitted on the keys are
 * Examine(A,i) – report the color of the ith element of A.
 * Swap(A,i,j) – swap the ith element of A with the jth element.
 * Find a correct and efficient algorithm for red-white-blue sorting. 
 * There is a linear-time solution.
 */
package algorithms.sort.redwhiteblue;

import algorithms.sort.redwhiteblue.RedWhiteBlueNode.Color;

/**
 *
 * @author Vlad Manolache
 */
public class RedWhiteBlueSort {
    
    public void sortElements(RedWhiteBlueNode[] array) {
        int red = 0;
        int blue = array.length - 1;
        int current = 0;
        
        while (current < blue) {
            if (array[current].compare(array[blue]) > 0) {
                swap(array[current], array[blue]);
                blue--;
            }
            else if(array[current].compare(array[red]) < 0) {
                swap(array[current], array[red]);
                red++;
            }
            else {
                current++;
            }
        } 
    }  
    
    public void swap(RedWhiteBlueNode a, RedWhiteBlueNode b) {
        Color tmp = a.getColor();
        a.setColor(b.getColor());
        b.setColor(tmp);
    }
}
