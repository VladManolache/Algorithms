package algorithms.math;

/**
 * Calculate the array where each item contains the product of all values 
 * excluding the value in the current position.
 * Restriction - do not use * or / operators.
 * 
 * @author Vlad Manolache
 */
public class ProductExcludingSelf {
 
    
    public int[] getProductExcludingSelf(int[] X) {
         
        int n = X.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] M = new int[n];
        
        left[0] = 1;
        right[n-1] = 1; 
        
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * X[i-1]; 
        }
        for (int i = 0; i < n; i++) { 
            System.out.print(left[i] + " ");
        }
        System.out.println();
        
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i+1] * X[i+1]; 
        }
        for (int i = 0; i < n; i++) { 
            System.out.print(right[i] + " ");
        }
        System.out.println();
         
        for (int i = 0; i < n; i++) {
            M[i] = left[i] * right[i]; 
        } 
        for(int i = 0; i < n; i++) {
            System.out.print(M[i] + " ");
        }
        System.out.println();
        
        return M;
    } 
}
