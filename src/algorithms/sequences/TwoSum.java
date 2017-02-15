package algorithms.sequences;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to 
 *  a specific target number.
 * The function twoSum should return indices of the two numbers such that 
 *  they add up to the target, where index1 must be less than index2. 
 *  Please note that your returned answers (both index1 and index2) are 
 *  NOT zero-based.You may assume that each input would have exactly one solution.
 * 
 * Example:
 * numbers=[2, 7, 11, 15], target=9
 * return [1, 2]
 * 
 * @author Vlad Manolache
 */
public class TwoSum {
    
    public int[] getTwoSum(int target, int[] numbers) {
        if (numbers == null) {
            return new int[] {};
        }
        
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if ( map.containsKey(numbers[i]) ) {
                return new int[] { map.get(numbers[i]), i };
            }
            else {
                map.put(target - numbers[i], i);
            }
        }
        
        return new int[] {-1, -1};
    }
    
}
