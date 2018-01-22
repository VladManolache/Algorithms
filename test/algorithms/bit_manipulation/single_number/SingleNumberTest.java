package algorithms.bit_manipulation.single_number;

import org.junit.jupiter.api.Test;

class SingleNumberTest {

    @Test
    void test() {
        SingleNumber singleNumber = new SingleNumber();
        int[] input = new int[] {1,2,2,1,3,4,3};
        assert(singleNumber.findSingleNumber(input) == 4);
    }
}
