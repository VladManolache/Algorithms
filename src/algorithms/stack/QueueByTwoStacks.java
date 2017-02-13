package algorithms.stack;

import java.util.Stack;

/**
 * As the title described, you should only use two stacks to implement a queue's actions.
 * The queue should support push(element), pop() and top() where pop is pop 
 *  the first(a.k.a front) element in the queue.
 * Both pop and top methods should return the value of first element.
 * 
 * Example:
 * push(1)
 * pop()     // return 1
 * push(2)
 * push(3)
 * top()     // return 2
 * pop()     // return 2
 * 
 * @author Vlad Manolache
 */
public class QueueByTwoStacks {
    
    /**
     * Elements in this stack are not yet processed. In order for them 
     *  to be used these must be moved to the fifoOrderStack which will reverse
     *  element order.
     */
    final private Stack<Integer> lifoOrderStack;
    
    /**
     * Elements in this stack are in reversed order and we are free to 
     *  remove them in O(1) time.
     */
    final private Stack<Integer> fifoOrderStack;
    
    public QueueByTwoStacks() {
        lifoOrderStack = new Stack<>();
        fifoOrderStack = new Stack<>();
    }
    
    public void push(int value) {
        lifoOrderStack.push(value);
    }
    
    public int pop() {
        if ( fifoOrderStack.empty() ) {
            while ( !lifoOrderStack.empty() ) {
                fifoOrderStack.push(lifoOrderStack.pop());
            } 
        }
        return fifoOrderStack.pop();
    }
    
    public int top() {
        if ( fifoOrderStack.empty() ) {
            while ( !lifoOrderStack.empty() ) {
                fifoOrderStack.push(lifoOrderStack.pop());
            }
        }
        return fifoOrderStack.peek();
    }
}
