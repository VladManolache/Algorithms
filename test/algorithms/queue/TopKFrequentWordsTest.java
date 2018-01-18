package algorithms.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vlad Manolache
 */
public class TopKFrequentWordsTest {
    
    @Test
    public void mainTest_V1() {
        String[] words = new String[] {
            "yes", "lint", "code",
            "yes", "code", "baby",
            "you", "baby", "chrome",
            "safari", "lint", "code",
            "body", "lint", "code"
        };
        
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> result = topKFrequentWords.topKFrequentWords(words, 3);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("code");
        expectedResult.add("lint");
        expectedResult.add("yes");         
        assert(result.equals(expectedResult));
    }
    
    @Test
    public void mainTest_V2() {
        String[] words = new String[] {
            "yes", "lint", "code",
            "yes", "code", "baby",
            "you", "baby", "chrome",
            "safari", "lint", "code",
            "body", "lint", "code"
        };
        
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> result = topKFrequentWords.topKFrequentWords(words, 4);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("code");
        expectedResult.add("lint");
        expectedResult.add("baby"); 
        expectedResult.add("yes"); 
        assert(result.equals(expectedResult));
    }
}
