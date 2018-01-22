package algorithms.data_structure.stack;

import java.util.Stack;

/**
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * It should support push, pop and min operation all in O(1) cost.
 *
 * Example:
 * push(1)
 * pop()   // return 1
 * push(2)
 * push(3)
 * min()   // return 2
 * push(1)
 * min()   // return 1
 * 
 * @author Vlad Manolache
 */
public class MinStack {
    
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        if ( minStack.isEmpty() || minStack.peek() > value ) {
            minStack.push(value);
        }
        stack.add(value);
    }
    
    public int pop() {        
        int value = stack.pop();
        if ( value == min() ) {
            minStack.pop();
        }
        return value;
    }
    
    public int min() {
        if ( minStack.isEmpty() ) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
