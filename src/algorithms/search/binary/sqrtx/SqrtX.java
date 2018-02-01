package algorithms.search.binary.sqrtx;

/**
 * Priority: High
 * Difficulty: Easy-Medium
 * Companies: Facebook, Amazon, Microsoft
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * If x is not a perfect square, return floor(sqrt(x))
 *
 * Example :
 * Input: 11
 * Output: 3
 *
 * @author Vlad Manolache
 */
public class SqrtX {
    
    public long sqrt_iterative(int x) {
        long start = 1;
        long end = x;
        long middle;
        
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (middle * middle <= x) {
                start = middle;
            }
            else {
                end = middle;
            }
        }
        
        if (end * end <= x) {
            return end;
        }
        else {
            return start;
        }
    }

    public int sqrt_recursive(int a) {
        // base cases
        if (a == 0 || a == 1) {
            return a;
        }

        return (int) find_recursive(a, 1, a / 2);
    }

    private long find_recursive(int x, long left, long right) {
        // base cases
        long mid = left + (right - left) / 2;
        if (left + 1 > right) {
            return left;
        }
        else if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
            // Result is real number bounded by [mid^2, (mid + 1)^2)
            return mid;
        }

        if (mid * mid > x) {
            return find_recursive(x, left, mid - 1);
        } else {
            return find_recursive(x, mid + 1, right);
        }
    }

}
