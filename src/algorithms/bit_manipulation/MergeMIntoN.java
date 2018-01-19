package algorithms.bit_manipulation;

/**
 * <br> Problem Statement :
 *
 * You are given two 32 bit numbers, N and M, and two bit positions,
 * i and j. Write a method to insert M into N such that M starts at
 * bit j and ends at bit i. You can assume that bits j through i have
 * enough space to fit all of M. That is, if M = 10011, you can assume
 * that there are at least 5 bits between j and i. You would not for example,
 * have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 *
 * Example :
 * Input N = 10000000000, M = 10011, i = 2, j = 6
 * Output N = 10001001100
 *
 * </br>
 *
 * @author Vlad Manolache
 */
public class MergeMIntoN {

    public int merge(int n, int m, int i, int j) {
        if (i >= 32 || j < i) {
            return 0;
        }

        int allOnes = ~0;
        int leftMask = allOnes << (j + 1);
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;

        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }
}
