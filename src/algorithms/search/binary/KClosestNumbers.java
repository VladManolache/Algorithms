package algorithms.search.binary;

/**
 * K Closest Numbers In Sorted Array
 *
 * Given a target number, a non-negative integer k and an integer array A sorted 
 * in ascending order, find the k closest numbers to target in A, 
 * sorted in ascending order by the difference between the number and target. 
 * Otherwise, sorted in ascending order by number if the difference is same.
 *
 * Example:
 * Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
 * Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].  
 * 
 * Link:
 * https://xizha677.gitbooks.io/codenotes/content/k-closest-numbers-in-sorted-array.html
 * 
 * @author Vlad Manolache
 */
public class KClosestNumbers {
    
    public int[] getKClosestNumbers(int k, int target, int[] numbers) {
        
        int closestPos = getClosest(k, target, numbers, 0, numbers.length - 1);
        
        int[] kNumbers = new int[k];
        int left = closestPos - 1;
        int right = closestPos;
        
        for ( int i = 0; i < k; i++ ) {
            if (left < 0) {
                kNumbers[i] = numbers[right++];
            } else if (right >= numbers.length) {
                kNumbers[i] = numbers[left--];
            } else if (Math.abs(numbers[left] - target) <= Math.abs(numbers[right] - target)) {
                kNumbers[i] = numbers[left--];
            } else {
                kNumbers[i] = numbers[right++];
            }
        }
    
        return kNumbers;
    }
    
    private int getClosest(int k, int target, int[] numbers, int start, int end) {
        int middle = start + (end - start) / 2;
             
        if (start >= end) {
            return start;
        }
        
        if (numbers[middle] == target) {
            return middle;
        }
        else if (numbers[middle] < target) {
            return getClosest(k, target, numbers, middle + 1, end);
        }
        else {
            return getClosest(k, target, numbers, start, middle);
        }
    }
    
}
