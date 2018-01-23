package algorithms.bit_manipulation.reference_operations;

public class ReferenceOperations {

    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    public static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static int clearBitsIthrough0(int num, int i) {
        int mask = (-1 << (i+1));
        return num & mask;
    }

    public static String toFullBinaryString(int a) {
        String s = "";
        for (int i = 0; i < 32; i++) {
            Integer lsb = a & 1;
            s = lsb.toString() + s;
            a = a >> 1;
        }
        return s;
    }
}
