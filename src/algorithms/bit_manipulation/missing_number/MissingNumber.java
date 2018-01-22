package algorithms.bit_manipulation.missing_number;

/**
 * Find the Missing Number
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 *
 * Example:
 * Given N = 3 and the array [0, 1, 3], return 2.
 *
 * Solution:
 * We could use the Single Number's idea to solve this question.
 * Calculate the xor sum from 0 to N
 * Calculate the xor sum for all element in given array
 * Xor these two sums
 *
 * @author Vlad Manolache
 */
public class MissingNumber {

    public int findMissingNumber(int[] numbers) {
        int num1 = 0;
        int num2 = 0;

        for (int number : numbers) {
            num1 ^= number;
        }

        for (int i = 1; i <= numbers.length; i++) {
            num2 ^= i;
        }

        return num1 ^ num2;
    }

}
