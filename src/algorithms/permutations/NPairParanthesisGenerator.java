/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.permutations;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class NPairParanthesisGenerator {
    
    public ArrayList<String> buildValidPermutations(int n) {
        ArrayList<String> list = new ArrayList();
                
        generateParanthesis(n, list, "", 0, 0);
        
        return list;        
    }
    
    public void generateParanthesis(int targetSize, ArrayList<String> accumulator, 
            String currentString, 
            int openedLeft, 
            int openedRight) {
        
        if ( currentString.length() == 2 * targetSize ) {
            if (openedLeft == openedRight) {
                accumulator.add(currentString);
            }
            return;
        }
                
        String newString;
        if ( openedLeft < targetSize ) {
            newString = currentString + "(";
            generateParanthesis(targetSize, accumulator, newString, openedLeft + 1, openedRight);
        }
        
        if ( openedRight < openedLeft ) {
            newString = currentString + ")";
            generateParanthesis(targetSize, accumulator, newString, openedLeft, openedRight + 1);
        }
    }
    
}
