package algorithms.search.other.wildcard_match;

/**
 * Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard pattern
 *  is matched with text. The matching should cover the entire text (not partial text).
 *
 * The wildcard pattern can include the character ‘*’
 * ‘*’ – matches any sequence of characters (including the empty sequence)
 *
 * @author Vlad Manolache
 */
public class WildcardMatch {
    
    public boolean match_dp(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        
        boolean[][] lookup = new boolean[n + 1][m + 1];
        lookup[0][0] = true;
              
        // Handle pattern is '*'
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                lookup[0][j] = lookup[0][j - 1];
            }
        } 
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
                }
                else if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    lookup[i][j] = lookup[i - 1][j - 1];
                }
            }
        }
        
        return lookup[n][m];
    }
    
    public boolean match_recursive(String str, String pattern) {
        if (pattern.equals("")) {
            return str.equals("");
        }
        else if (pattern.charAt(0) == '*') {
            return match_recursive(str, pattern.substring(1)) ||
                   match_recursive(str.substring(1), pattern);
        }
        else if (!str.equals("") && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '?')) {
            return match_recursive(str.substring(1), pattern.substring(1));
        }
        else {
            return false;
        }
    }
    
    public boolean match_iterative(String str, String pattern) {
        int s = 0; // cursor for traversal in str.
        int p = 0; // cursor for traversal in pattern.
        int starIdx = -1; // once we found a star, we want to record the place of the star.
        int match = 0; // once we found a star, we want to start to match the rest of pattern with str, starting from match; this is for remembering the place where we need to start.
         
        // we check and match every char for str.
        while (s < str.length()) {
            if (p < pattern.length() && pattern.charAt(p) == '*' ) {
                starIdx = p;
                p++;
                match = s;
            }
            else if (p < pattern.length() && (pattern.charAt(p) == str.charAt(s) || pattern.charAt(p) == '?')) {
                p++;
                s++;
            }
            else if (starIdx != -1) {
                match++;
                s = match;
                p = starIdx + 1;
            } 
            else {
                return false;
            }
        }
        
        // when we finish matching all characters in str, is pattern also finished ? 
        // We can only allow '*' as the rest of pattern
        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }
   
        return p == pattern.length();
    }
    
}
