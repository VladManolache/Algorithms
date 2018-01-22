package algorithms.search;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vlad Manolache
 */
public class WildcardMatchTest {
    
    private WildcardMatch wildcardMatch = new WildcardMatch();
    
    boolean executeMatch(String str, String pattern) {
        return wildcardMatch.match_dp(str, pattern) &&
                wildcardMatch.match_recursive(str, pattern) &&
                wildcardMatch.match_iterative(str, pattern);
    }
    
    @Test
    void testMatch() {
        String str = "baaabab";
        String[] patterns = {
            "*****ba*****ab",
            "ba*****ab",
            "ba*ab",
            "*a*****ab",
            "ba*ab****",
            "****",
            "*",
            "b*b",
            "baaabab", 
            "*baaaba*"
        };
        
        for (String pattern : patterns) {
            assert(executeMatch(str, pattern));
        }
    }
    
    @Test
    void testNotMatch() {
        String str = "baaabab";
        String[] patterns = {
            "a*ab",
            "a*****ab",  
            "aa?ab",
            "?baaabab",
        };
                
        for (String pattern : patterns) {
            assert(executeMatch(str, pattern) == false);
        }
    }
    
    @Test
    void testMapMatch() {
        Map<String, String> map = new HashMap();
        map.put("aa", "*aa");
        map.put("aaaaabbbccc", "*aa*c");
        map.put("aaaaabbbccc", "*aa*bbc*");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            assert(executeMatch(entry.getKey(), entry.getValue()) == true);
        }
    }
    
    @Test
    void testMapNotMatch() {
        Map<String, String> map = new HashMap();
        map.put("aa", "*abc");
        
        for (Map.Entry<String, String> entry: map.entrySet()) {
            assert(executeMatch(entry.getKey(), entry.getValue()) == false);
        }
    }
   
    @Test
    void testCasesWithRepeatingCharacterSequences() {
        assert(executeMatch("abcccd", "*ccd") == true);
        assert(executeMatch("mississipissippi", "*issip*ss*") == true);
        assert(executeMatch("xxxx*zzzzzzzzy*f", "xxxx*zzy*fffff") == false);
        assert(executeMatch("xxxx*zzzzzzzzy*f", "xxx*zzy*f") == true);
        assert(executeMatch("xxxxzzzzzzzzyf", "xxxx*zzy*fffff") == false);
        assert(executeMatch("xxxxzzzzzzzzyf", "xxxx*zzy*f") == true);
        assert(executeMatch("xyxyxyzyxyz", "xy*z*xyz") == true);
        assert(executeMatch("mississippi", "*sip*") == true);
        assert(executeMatch("xyxyxyxyz", "xy*xyz") == true);
        assert(executeMatch("mississippi", "mi*sip*") == true);
        assert(executeMatch("ababac", "*abac*") == true);
        assert(executeMatch("ababac", "*abac*") == true);
        assert(executeMatch("aaazz", "a*zz*") == true);
        assert(executeMatch("a12b12", "*12*23") == false);
        assert(executeMatch("a12b12", "a12b") == false);
        assert(executeMatch("a12b12", "*12*12*") == true);
    }
    
    @Test
    void testStringIncludesWildcard() {
        assert(executeMatch("*", "*") == true);
        assert(executeMatch("a*abab", "a*b") == true);
        assert(executeMatch("a*r", "a*") == true);
        assert(executeMatch("a*ar", "a*aar") == false);
    }
    
    @Test 
    void testMixed() {
        assert(executeMatch("a", "??") == false);
        assert(executeMatch("ab", "?*?") == true);
        assert(executeMatch("ab", "*?*?*") == true);
        assert(executeMatch("abc", "?**?*?") == true);
        assert(executeMatch("abc", "?**?*&?") == false);
        assert(executeMatch("abcd", "?b*??") == true);
        assert(executeMatch("abcd", "?a*??") == false);
        assert(executeMatch("abcd", "?**?c?") == true);
        assert(executeMatch("abcd", "?**?d?") == false);
        assert(executeMatch("abcde", "?*b*?*d*?") == true);
    }
    
    @Test
    void testManyWildcards() {
        assert(executeMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
            "a*a*a*a*a*a*aa*aaa*a*a*b") == true); 
        assert(executeMatch("abababababababababababababababababababaacacacacacaacadaeafagahaiajakalaaaaaaaaaaaaaaaaaffafagaagggagaaaaaaaab", 
            "*a*b*ba*ca*a*aa*aaa*fa*ga*b*") == true);
        assert(executeMatch("abababababababababababababababababababaacacacacacaacadaeafagahaiajakalaaaaaaaaaaaaaaaaaffafagaagggagaaaaaaaab", 
            "*a*b*ba*ca*a*x*aaa*fa*ga*b*") == false);
        assert(executeMatch("abababababababababababababababababababaacacacacacaacadaeafagahaiajakalaaaaaaaaaaaaaaaaaffafagaagggagaaaaaaaab", 
            "*a*b*ba*ca*aaaa*fa*ga*gggg*b*") == false);
        assert(executeMatch("abababababababababababababababababababaacacacacacaacadaeafagahaiajakalaaaaaaaaaaaaaaaaaffafagaagggagaaaaaaaab", 
            "*a*b*ba*ca*aaaa*fa*ga*ggg*b*") == true);
        assert(executeMatch("aaabbaabbaab", "*aabbaa*a*") == true);
        assert(executeMatch("a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*", 
            "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*") == true);
        assert(executeMatch("aaaaaaaaaaaaaaaaa", 
            "*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*") == true);
        assert(executeMatch("aaaaaaaaaaaaaaaa", 
            "*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*") == false);
        assert(executeMatch("abc*abcd*abcde*abcdef*abcdefg*abcdefgh*abcdefghi*abcdefghij*abcdefghijk*abcdefghijkl*abcdefghijklm*abcdefghijklmn", 
            "abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*") == false);
        assert(executeMatch("abc*abcd*abcd*abc*abcd", "abc*abc*abc*abc*abc") == 
            false);
        assert(executeMatch("abc", "********a********b********c********") == 
            true);
        assert(executeMatch("********a********b********c********", "abc") == 
            false);
        assert(executeMatch("abc", "********a********b********b********") == 
            false);
        assert(executeMatch("*abc*", "***a*b*c***") == true);
    }
    
    @Test
    void testOperationOrder() {
        assert(executeMatch("abc*abcd*abcde*abcdef*abcdefg*abcdefgh*abcdefghi*abcdefghij*abcdefghijk*abcdefghijkl*abcdefghijklm*abcdefghijklmn", 
            "abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*") == true);
        assert(executeMatch("abc*abcd*abcd*abc*abcd*abcd*abc*abcd*abc*abc*abcd", 
            "abc*abc*abc*abc*abc*abc*abc*abc*abc*abc*abcd") == true);
    }
}
