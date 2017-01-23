/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.search;

/**
 *
 * @author user
 */
public class SqrtX {
    
    public long getSqrt(int x) {
        long start = 1;
        long end = x;
        long middle;
        
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (middle * middle <= x) {
                start = middle;
            }
            else {
                end = middle;
            }
        }
        
        if (end * end <= x) {
            return end;
        }
        else {
            return start;
        }
    }
    
}
