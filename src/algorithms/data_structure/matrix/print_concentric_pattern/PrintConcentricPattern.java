package algorithms.data_structure.matrix.print_concentric_pattern;

import java.util.ArrayList;

/**
 * Description:
 * Print concentric rectangular pattern in a 2d matrix.
 * Let us show you some examples to clarify what we mean.
 *
 * Example 1:
 * Input: A = 4.
 * Output:
 *  4 4 4 4 4 4 4
 *  4 3 3 3 3 3 4
 *  4 3 2 2 2 3 4
 *  4 3 2 1 2 3 4
 *  4 3 2 2 2 3 4
 *  4 3 3 3 3 3 4
 *  4 4 4 4 4 4 4
 *
 * Example 2:
 * Input: A = 3.
 * Output:
 *  3 3 3 3 3
 *  3 2 2 2 3
 *  3 2 1 2 3
 *  3 2 2 2 3
 *  3 3 3 3 3
 *
 * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
 * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 *
 * @author Vlad Manolache
 */

public class PrintConcentricPattern {

    public ArrayList<ArrayList<Integer>> printPattern(int A) {

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int offset = 0;

        for (int i = 0; i < 2 * A - 1; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                int cutoff = A - j < A - offset ? A - offset : A - j;
                list.add(cutoff);
            }
            for (int j = A + 1; j < 2 * A; j++) {
                int cutoff = j - A + 1 < A - offset ? A - offset : j - A + 1;
                list.add(cutoff);
            }
            results.add(list);

            if (i < A - 1) {
                offset++;
            }
            else {
                offset--;
            }
        }

        return results;
    }

}
