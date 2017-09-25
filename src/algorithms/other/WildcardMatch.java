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
              
        // Handle pattern is *
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                lookup[0][j] = lookup[0][j - 1];
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1];
                }
                else {
                   switch (pattern.charAt(j - 1)) {
                    case '?':
                        lookup[i][j] = lookup[i - 1][j - 1];
                        break;
                    case '*':
                        lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
                        break;
                    default:
                        lookup[i][j] = false;
                        break;
                   }
                }
            }
        }
        
        return lookup[n][m];
    }
    
    public boolean match_recursive(String str, String pattern) {
        if (pattern.equals("*") || str.equals(pattern)) return true;
        if (str.equals("")) return false;
            
        else if (str.length() == 0 && pattern.length() == 0) {
            return true;
        }
        else if (str.length() == 0 || pattern.length() == 0) {
            return false;
        }
        else if (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '?') {
            return match_recursive(str.substring(1), pattern.substring(1));
        }
        else if (pattern.charAt(0) == '*') {
            return match_recursive(str, pattern.substring(1)) || match_recursive(str.substring(1), pattern);
        }
        else {
            return false;
        }
    }
    
    public boolean match_iterative(String str, String pattern) {
        return false;
    }
}
