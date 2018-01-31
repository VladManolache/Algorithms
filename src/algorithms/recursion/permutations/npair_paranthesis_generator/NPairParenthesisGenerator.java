package algorithms.recursion.permutations.npair_paranthesis_generator;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class NPairParenthesisGenerator {
    
    public ArrayList<String> buildValidPermutations(int n) {
        ArrayList<String> list = new ArrayList<>();

        generateParenthesis(n, list, "", 0, 0);
        
        return list;        
    }
    
    private void generateParenthesis(int targetSize,
                                     ArrayList<String> accumulator,
                                     String currentString,
                                     int openedLeft,
                                     int openedRight) {

        if (currentString.length() == 2 * targetSize) {
            if (openedLeft == openedRight) {
                accumulator.add(currentString);
            }
            return;
        }

        String newString;
        if (openedLeft < targetSize) {
            newString = currentString + "(";
            generateParenthesis(targetSize, accumulator, newString, openedLeft + 1, openedRight);
        }

        if (openedRight < openedLeft) {
            newString = currentString + ")";
            generateParenthesis(targetSize, accumulator, newString, openedLeft, openedRight + 1);
        }
    }
}
