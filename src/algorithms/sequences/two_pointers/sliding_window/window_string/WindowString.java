package algorithms.sequences.two_pointers.sliding_window.window_string;

/**
 * Priority: High
 * Difficulty: Medium-High
 * Companies: Google, Directi
 *
 * Description:
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T
 *  in linear time complexity.
 * Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
 *
 * Example :
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 *
 * Idea: use a sliding window
 *
 * @author Vlad Manolache
 */
public class WindowString {

    private static final int numberOfCharacters = 256;

    public String minWindow(String A, String B) {
        if (A.length() < B.length()) {
            return "";
        }

        int hashA[] = new int[numberOfCharacters];
        int hashB[] = new int[numberOfCharacters];

        // store occurrence of characters of the pattern.
        for (int i = 0; i < B.length(); i++) {
            hashA[B.charAt(i)]++;
        }

        int start = 0;
        int start_index = -1;
        int minLength = Integer.MAX_VALUE;

        int count = 0;  // count of characters
        for (int j = 0; j < A.length(); j++) {
            hashB[A.charAt(j)]++;

            // If string's char matches with pattern's char then increment count.
            if ( hashA[A.charAt(j)] != 0 && hashB[A.charAt(j)] <= hashA[A.charAt(j)] ) {
                count++;
            }

            // if all the characters are matched
            if (count == B.length()) {

                // Try to minimize the window i.e., check if any character is occurring more no. of times than
                //  its occurrence in pattern, if yes then remove it from the start and also remove the useless characters.
                while (hashB[A.charAt(start)] > hashA[A.charAt(start)]  ||
                        hashA[A.charAt(start)] == 0) {

                    if (hashB[A.charAt(start)] > hashA[A.charAt(start)]) {
                        hashB[A.charAt(start)]--;
                    }

                    start++;
                }

                int windowLength = j - start + 1;
                if (minLength > windowLength) {
                    minLength = windowLength;
                    start_index = start;
                }
            }
        }

        if (start_index != -1) {
            return A.substring(start_index, start_index + minLength);
        }
        return "";
    }

}
