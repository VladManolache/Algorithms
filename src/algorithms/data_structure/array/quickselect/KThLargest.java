package algorithms.data_structure.array.quickselect;

/**
 * Find K-th largest element in an array. You can swap elements in the array.
 *  
 * Example:
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 
 *  3rd largest element is 3 and etc.
 *
 * @author Vlad Manolache
 */
public class KThLargest {
    
    public int kthElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        
        return quickSelect(nums, 0, n - 1, n - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }
         
        int pivotIdx = left + (right - left) / 2;
        pivotIdx = partition(nums, left, right, pivotIdx);
        if (pivotIdx == n) {
            return nums[n];
        } else if (pivotIdx > n) {
            return quickSelect(nums, left, pivotIdx - 1, n);
        } else {
            return quickSelect(nums, pivotIdx + 1, right, n);
        }
    }
    
    private int partition(int[] nums, int left, int right, int pIdx) {
        int pivot = nums[pIdx];
        swap(nums, pIdx, right);
        
        int storedIdx = left;
        while (left < right) {
            if (nums[left] < pivot) {
                swap(nums, left, storedIdx++);
            }
            left++;
        }
        
        swap(nums, storedIdx, right);
        
        return storedIdx;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}
