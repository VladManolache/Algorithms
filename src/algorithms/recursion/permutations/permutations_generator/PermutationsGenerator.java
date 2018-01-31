package algorithms.recursion.permutations.permutations_generator;

import java.util.HashSet;
import java.util.Set;

/**
 * Generate all permutations of a string of characters.

 * @author Vlad Manolache
 */
public class PermutationsGenerator {

    Set<String> generatePermutations_v1(String str) {
        int length = str.length();
        boolean[] used = new boolean[length];
        StringBuffer out = new StringBuffer();
        char[] in = str.toCharArray();
        Set<String> accumulator = new HashSet<>();
        return buildPermutations_v1(accumulator, in, out, used, length, 0);
    }

    private Set<String> buildPermutations_v1(Set<String> accumulator, char[] in,
                                             StringBuffer out, boolean[] used,
                                             int length, int level) {
        if (level == length) {
            accumulator.add(out.toString());
            return accumulator;
        }
        
        for (int i = 0; i < length; ++i) {
            // Decide if we should continue.
            if (used[i]) {
                continue;
            }

            // Make current move
            out.append(in[i]);
            used[i] = true;

            // Make next moves
            buildPermutations_v1(accumulator, in, out, used, length, level + 1);

            // Backtracking
            used[i] = false;
            out.setLength(out.length() - 1);
        }

        return accumulator;
    }
    
    public Set<String> generatePermutations_v2(String string) {
        Set<String> accumulator = new HashSet<>();
        return buildPermutations_v2(accumulator, "", string);
    }
    
    private Set<String> buildPermutations_v2(Set<String> accumulator,
                                             String currentString,
                                             String initialString) {
        
        if (currentString.length() == initialString.length()) {
            accumulator.add(currentString);
            return accumulator;
        }

        for (int i = 0; i < initialString.length(); i++) {
            if ( !currentString.contains(String.valueOf(initialString.charAt(i))) ) {
                String newString = currentString + initialString.charAt(i);
                buildPermutations_v2(accumulator, newString, initialString);
            }
        }

        return accumulator;
    } 
}
