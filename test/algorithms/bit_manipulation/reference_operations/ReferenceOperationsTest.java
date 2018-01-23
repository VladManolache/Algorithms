package algorithms.bit_manipulation.reference_operations;

import org.junit.jupiter.api.Test;

class ReferenceOperationsTest {

    private int number = 59;

    @Test
    void testGetBit() {
        System.out.println("Testing with number: " + number);

        // Get Bit
        System.out.println("Get Bit");
        System.out.println(ReferenceOperations.toFullBinaryString(number));
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int res = ReferenceOperations.getBit(number, i) ? 1 : 0;
            System.out.print(res);
            sb.append(res);
        }
        assert(sb.toString().equals("00000000000000000000000000111011"));
    }

    @Test
    void testUpdateBit() {
        System.out.println("\n\nUpdate Bit");
        int num1 = 1578; // arbitrary number
        for (int i = 31; i >= 0; i--) {
            num1 = ReferenceOperations.updateBit(num1, i, ReferenceOperations.getBit(number, i));
        }
        System.out.println(num1);
        assert (num1 == 59);
    }

    @Test
    void testGetAndSetBit() {
        System.out.println("\nSet and Clear Bit");
        int num2 = 1578; // arbitrary number
        for (int i = 31; i >= 0; i--) {
            if (ReferenceOperations.getBit(number, i)) {
                num2 = ReferenceOperations.setBit(num2, i);
            } else {
                num2 = ReferenceOperations.clearBit(num2, i);
            }
        }
        System.out.println(num2);
        assert(num2 == 59);
    }

    @Test
    void clearBitsMSBThroughI() {
        number = 13242352;
        int clearMSBThrough = 4;
        System.out.println("\nClear bits MSB through " + clearMSBThrough);
        System.out.println(ReferenceOperations.toFullBinaryString(number));
        int num3 = ReferenceOperations.clearBitsMSBthroughI(number, clearMSBThrough);
        System.out.println(ReferenceOperations.toFullBinaryString(num3));
        assert(num3 == 0b00000000000000000000000000000000);
    }

    @Test
    void clearBitsIThrough0() {
        int clearToLSB = 2;
        System.out.println("\nClear bits " + clearToLSB + " through 0");
        number = -1;
        System.out.println(ReferenceOperations.toFullBinaryString(number));
        int num4 = ReferenceOperations.clearBitsIthrough0(number, clearToLSB);
        System.out.println(ReferenceOperations.toFullBinaryString(num4));
        assert(num4 == 0b11111111111111111111111111111000);
    }
}
