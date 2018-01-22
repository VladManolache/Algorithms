package algorithms.permutations;

import java.util.ArrayList;

/**
 * Generate all permutations of a string of characters.

 * @author Vlad Manolache
 */
public class PermutationsGenerator {
    
    void generatePermutations_v1(String str) {
        int length = str.length();
        boolean[] used = new boolean[length];
        StringBuffer out = new StringBuffer();
        char[] in = str.toCharArray();
        buildPermutations_v1(in, out, used, length, 0);
    }

    private void buildPermutations_v1(char[] in, StringBuffer out,
            boolean[] used, int length, int level) {
        if (level == length) {
            return;
        }
        
        for (int i = 0; i < length; ++i) {
            if (used[i]) { 
                continue;
            }
            out.append(in[i]);
            used[i] = true;
            buildPermutations_v1(in, out, used, length, level + 1);
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }
    
    public ArrayList<String> generatePermutations_v2(String string) {
        ArrayList<String> accumulator = new ArrayList<>();
        return buildPermutations_v2(accumulator, "", string);
    }
    
    private ArrayList<String> buildPermutations_v2(ArrayList<String> accumulator, 
            String currentString, 
            String initialString) {
        
        if (currentString.length() == initialString.length()) {
            if (!accumulator.contains(currentString)) {
                accumulator.add(currentString);
            }
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
