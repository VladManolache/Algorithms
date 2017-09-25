package algorithms.other;

/**
 *
 * @author Vlad Manolache
 */
public class WildcardMatch {
    
    public boolean match(String str, String pattern) {
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
        return false;
    }
    
}
