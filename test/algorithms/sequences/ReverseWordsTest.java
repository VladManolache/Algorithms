package algorithms.sequences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Vlad Manolache
 */
public class ReverseWordsTest {

    @Test
    void mainTest() {
        ReverseWords reverseWords = new ReverseWords();

        // Input phrase to reverse.
        char[] phrase = "My name is Chris".toCharArray();

        char[] reversedPhrase1 = reverseWords.reverseWords1(phrase);
        char[] reversedPhrase2 = reverseWords.reverseWords2(phrase);

        System.out.println(reversedPhrase1);
        assertTrue(Arrays.toString(reversedPhrase1).equalsIgnoreCase(Arrays.toString(phrase)));
        assertTrue(Arrays.toString(reversedPhrase2).equalsIgnoreCase(Arrays.toString(phrase)));
    }
}
