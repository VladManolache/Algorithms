package algorithms.bit_manipulation.missing_number;

import org.junit.jupiter.api.Test;

class MissingNumberTest {

    @Test
    void test3MissingMiddle() {
        MissingNumber missingNumber = new MissingNumber();
        int[] input = new int[] {0,1,3};
        assert(missingNumber.findMissingNumber(input) == 2);
    }

    @Test
    void test10MissingMiddle() {
        MissingNumber missingNumber = new MissingNumber();
        int[] input = new int[] {0,1,2,3,4,5,7,8,9,10};
        assert(missingNumber.findMissingNumber(input) == 6);
    }

    @Test
    void test15MissingEnd() {
        MissingNumber missingNumber = new MissingNumber();
        int[] input = new int[] {0,1,2,3,4,5,7,8,9,10,11,12,13,14};
        assert(missingNumber.findMissingNumber(input) == 6);
    }
}
