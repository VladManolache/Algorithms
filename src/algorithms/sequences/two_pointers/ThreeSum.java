package algorithms.sequences.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that 
 *  a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. 
 *  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) 
 *  The solution set must not contain duplicate triplets.
 * 
 * Example:
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * @author Vlad Manolache
 */
public class ThreeSum {
    
    public ArrayList<ArrayList<Integer>> getThreeSumPairs(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        
        Arrays.sort(numbers);
        
        HashSet<ArrayList<Integer>> hset = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int num = numbers[i] + numbers[left] + numbers[right];
                if (num == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(numbers[i]);
                    temp.add(numbers[left]);
                    temp.add(numbers[right]);
                    Collections.sort(temp);
                    hset.add(temp);
                    left++;
                    right--; 
                }
                else if (num > 0 ) {
                    right--;
                }
                else if (num < 0) {
                    left++;
                }
            }
        }

        res.addAll(hset);
        
        return res;
    }
    
}
