package algorithms.sequences.subsequence;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a sequence, split it into the list of minimal sequences such that an element
 *  cannot be part of more than one sequence.
 *
 * @author Vlad Manolache
 */
public class MinimalSequenceLength {

    public List<Integer> findLength(List<Character> inputList) {
        System.out.println("Input: " + inputList);

        List<Integer> results = new ArrayList<>();

        int lastIndex;
        int currentLength = 1;
        int next;
        int startOfSequence;

        for (int i = 0; i < inputList.size(); i++) {
            lastIndex = inputList.lastIndexOf(inputList.get(i));
            if (lastIndex == i) {
                results.add(currentLength);
                currentLength = 1;
                printSequence(inputList, results, i, i);
            }
            else {
                startOfSequence = i;
                for (int j = i; j < lastIndex; j++) {
                    next = inputList.lastIndexOf(inputList.get(j));
                    lastIndex = lastIndex > next ? lastIndex : next;
                }
                i = lastIndex;
                results.add(lastIndex - startOfSequence + 1);
                printSequence(inputList, results, startOfSequence, lastIndex);
            }
        }
        System.out.println("Sequence lengths: " + results);
        System.out.println();

        return results;
    }

    private void printSequence(List<Character> input, List<Integer> results, Integer start, Integer end) {
        System.out.print("Sequence " + results.size() + ": ");
        for (int k = start; k <= end; k++) {
            System.out.print(input.get(k) + " ");
        }
        System.out.println();
    }

}