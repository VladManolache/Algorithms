package algorithms.stack;

import java.util.Stack;

/**
 * Sort a stack in ascending order (with biggest terms on top).
 * You may use at most one additional stack to hold items, but you may not copy 
 *  the elements into any other data structure (e.g. array).
 * 
 * Example:
 * Given stack = [4, 2, 3, 1]
 * return: [4, 3, 2, 1]
 * 
 * @author Vlad Manolache
 */
public class StackSorting {
    
     public void stackSort(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return;
        }
        
        Stack<Integer> st = new Stack<>();
        while ( !stack.isEmpty() ) {
            int value = stack.pop();
            
            while ( !st.isEmpty() && st.peek() < value ) {
                stack.push( st.pop() );
            }
            
            st.push(value);
        }
        
        stack.addAll(st);
     }
    
}
