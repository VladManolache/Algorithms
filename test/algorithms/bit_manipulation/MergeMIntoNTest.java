package algorithms.bit_manipulation;

import org.junit.jupiter.api.Test;

class MergeMIntoNTest {

    private MergeMIntoN mergeMIntoN = new MergeMIntoN();

    @Test
    void test() {
        assert(mergeMIntoN.merge(0b10000000000, 0b10011, 2, 6) == 0b10001001100);
    }

}
