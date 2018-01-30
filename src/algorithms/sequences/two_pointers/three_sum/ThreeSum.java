package algorithms.sequences.two_pointers.three_sum;

import java.util.*;

/**
 * Priority: High
 * Difficulty: Medium
 * Companies: Facebook, Google
 *
 * Description:
 * Given an array S of n integers, are there elements a, b, c in S such that 
 *   a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 *
 * Note: The solution set must not contain duplicate triplets.
 * 
 * Example:
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * @author Vlad Manolache
 */
public class ThreeSum {

    public ArrayList<List<Integer>> threeSumPairs(int[] numbers) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        
        Arrays.sort(numbers);

        HashSet<List<Integer>> hset = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int num = numbers[i] + numbers[left] + numbers[right];
                if (num > 0 ) {
                    right--;
                }
                else if (num < 0) {
                    left++;
                }
                else {
                    List<Integer> temp = Arrays.asList(numbers[i], numbers[left], numbers[right]);
                    Collections.sort(temp);
                    hset.add(temp);
                    left++;
                    right--; 
                }
            }
        }

        res.addAll(hset);
        
        return res;
    }
    
}
