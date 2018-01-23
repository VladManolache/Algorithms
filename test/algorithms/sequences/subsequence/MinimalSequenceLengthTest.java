package algorithms.sequences.subsequence;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sequence generator: http://www.dave-reed.com/Nifty/randSeq.html
 */
class MinimalSequenceLengthTest {

    @Test
    void test1() {
        List<Character> list = new ArrayList<>();
        list.add('a'); list.add('b'); list.add('c'); list.add('d'); list.add('a');
        list.add('e'); list.add('f'); list.add('g'); list.add('h'); list.add('i');
        list.add('j'); list.add('e');

        List<Integer> results = new ArrayList<>();
        results.add(5); results.add(7);

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    @Test
    void test2() {
        List<Character> list = new ArrayList<>();
        list.add('z'); list.add('z'); list.add('c'); list.add('b'); list.add('z');
        list.add('c'); list.add('h'); list.add('f'); list.add('i'); list.add('h');
        list.add('i');

        List<Integer> results = new ArrayList<>();
        results.add(6); results.add(5);

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    @Test
    void test3() {
        List<Character> list = new ArrayList<>();
        list.add('a'); list.add('b'); list.add('a'); list.add('b'); list.add('c');
        list.add('b'); list.add('a'); list.add('c'); list.add('a'); list.add('d');
        list.add('e'); list.add('f'); list.add('e'); list.add('g'); list.add('d');
        list.add('e'); list.add('h'); list.add('i'); list.add('j');
        list.add('h'); list.add('k'); list.add('l'); list.add('i'); list.add('j');

        List<Integer> results = new ArrayList<>();
        results.add(9); results.add(7); results.add(8);

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    private List<Character> stringToList(String string) {
        return string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    @Test
    void testLength10() {
        String input = "xazktwjewv";
        List<Character> list = new ArrayList<>(stringToList(input));

        List<Integer> results = new ArrayList<>(Arrays.asList(1,1,1,1,1,4,1));

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    @Test
    void testLength15() {
        String input = "flijvxilptqqbed";
        List<Character> list = new ArrayList<>(stringToList(input));

        List<Integer> results = new ArrayList<>(Arrays.asList(1,7,1,1,2,1,1,1));

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    @Test
    void testLength20() {
        String input = "cbirztrymfsdzaiiwewg";
        List<Character> list = new ArrayList<>(stringToList(input));

        List<Integer> results = new ArrayList<>(Arrays.asList(1,1,14,3,1));

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    @Test
    void testLength30() {
        String input = "ebfcefefefpjjjjmlmppqxzuwqyxzy";
        List<Character> list = new ArrayList<>(stringToList(input));

        List<Integer> results = new ArrayList<>(Arrays.asList(10,10,10));

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }

    @Test
    void testLength50() {
        String input = "dmgnehflmkljalgmjdgbemjlcszpszruvvqvsrvszvzzpuwyyy";
        List<Character> list = new ArrayList<>(stringToList(input));

        List<Integer> results = new ArrayList<>(Arrays.asList(24,1,21,1,3));

        MinimalSequenceLength minimalSequenceLength = new MinimalSequenceLength();
        assert(minimalSequenceLength.findLength_v1(list).equals(results));
        assert(minimalSequenceLength.findLength_v2(list).equals(results));
    }
}
