package algorithms.recursion.dynamic_programming.triple_step;

import org.junit.jupiter.api.Test;

class TripleStepTest {

    @Test
    void testMain() {
        TripleStep tripleStep = new TripleStep();
        int N = 5;
        int expectedResult = 13;
        int count = tripleStep.countWays(N);
        assert(count == expectedResult);
    }
}
