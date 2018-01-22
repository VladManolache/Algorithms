package algorithms.bit_manipulation.single_number;

/**
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 *
 * Example:
 * Given [1,2,2,1,3,4,3], return 4
 *
 * Solution:
 * Due to the property of xor, we have a^a = 0. Therefore, a^b^a = b
 *
 * @author Vlad Manolache
 */
public class SingleNumber {

    public int findSingleNumber(int[] numbers) {
        int num = 0;
        for (int number : numbers) {
            num ^= number;
        }
        return num;
    }

}
