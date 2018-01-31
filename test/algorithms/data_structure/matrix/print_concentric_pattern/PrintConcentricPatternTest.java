package algorithms.data_structure.matrix.print_concentric_pattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrintConcentricPatternTest {

    @Test
    void testSize3() {
        ArrayList<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(Arrays.asList(3, 3, 3, 3, 3));
        expectedResults.add(Arrays.asList(3, 2, 2, 2, 3));
        expectedResults.add(Arrays.asList(3, 2, 1, 2, 3));
        expectedResults.add(Arrays.asList(3, 2, 2, 2, 3));
        expectedResults.add(Arrays.asList(3, 3, 3, 3, 3));

        PrintConcentricPattern printConcentricPattern = new PrintConcentricPattern();
        assert(printConcentricPattern.printPattern(3).equals(expectedResults));
    }

    @Test
    void testSize4() {
        ArrayList<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(Arrays.asList(4, 4, 4, 4, 4, 4, 4));
        expectedResults.add(Arrays.asList(4, 3, 3, 3, 3, 3, 4));
        expectedResults.add(Arrays.asList(4, 3, 2, 2, 2, 3, 4));
        expectedResults.add(Arrays.asList(4, 3, 2, 1, 2, 3, 4));
        expectedResults.add(Arrays.asList(4, 3, 2, 2, 2, 3, 4));
        expectedResults.add(Arrays.asList(4, 3, 3, 3, 3, 3, 4));
        expectedResults.add(Arrays.asList(4, 4, 4, 4, 4, 4, 4));

        PrintConcentricPattern printConcentricPattern = new PrintConcentricPattern();
        assert(printConcentricPattern.printPattern(4).equals(expectedResults));
    }
}
