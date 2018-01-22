package algorithms.data_structure.queue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Given two integer arrays sorted in ascending order and an integer k. 
 *  Define sum = a + b, where a is an element from the first array and b is 
 *  an element from the second one. Find the kth smallest sum out of all possible sums.
 *
 * Example:
 * Given [1, 7, 11] and [2, 4, 6].
 * For k = 3, return 7.
 * For k = 4, return 9.
 * For k = 8, return 15.
 * 
 * @author Vlad Manolache
 */
class SumType {
    int a; //a idx
    int b; //b idx
    int sum; // sum of A[a] and B[b]
    
    public SumType(int inA, int inB, int inSum) {
        this.a = inA;
        this.b = inB;
        this.sum = inSum;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ( !(obj instanceof SumType) ) return false; 
        return this.a == ((SumType) obj).a && 
                this.b == ((SumType) obj).b; 
    }

    @Override
    public int hashCode() { 
        return (this.a + "," + this.b).hashCode();
    }
}

public class KLargestSumTwoArrays {
    
    private Queue<SumType> minQueue; 
    private final int k;
    
    public KLargestSumTwoArrays(int k) {
        this.k = k;
    }
    
    public int kLargestSum(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return Integer.MIN_VALUE;
        }
        
        int m = array1.length;
        int n = array2.length;
        if (n * m < k) {
            return Integer.MIN_VALUE;
        }
        
        minQueue = new PriorityQueue<>(Math.min(Math.min(n, m), k), Comparator.comparingInt(a -> a.sum));
        
        SumType temp = new SumType(0, 0, array1[0] + array2[0]);
        Set<SumType> uniqueValues = new HashSet<>();
        minQueue.add(temp);        
        uniqueValues.add(temp); 
        
        int result = Integer.MIN_VALUE; 
        for (int index = 0; index < k; index++) {
            temp = minQueue.poll();
            result = temp.sum;
            System.out.println(temp.a + " " + temp.b + " " + temp.sum);

            if (temp.a + 1 < m) {
                SumType tempSum = new SumType(temp.a + 1, temp.b, array1[temp.a + 1] + array2[temp.b]);
                if (!uniqueValues.contains(tempSum)) {
                    minQueue.add(tempSum);
                    uniqueValues.add(tempSum);
                } 
            }
            if (temp.b + 1 < n) {
                SumType tempSum = new SumType(temp.a, temp.b + 1, array1[temp.a] + array2[temp.b + 1]);
                if (!uniqueValues.contains(tempSum)) {
                    minQueue.add(tempSum);
                    uniqueValues.add(tempSum);
                } 
            } 
        }
         
        return result;
    }
    
}
