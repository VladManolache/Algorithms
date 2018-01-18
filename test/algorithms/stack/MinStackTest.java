package algorithms.stack;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class MinStackTest {
    
    @Test
    public void mainTest() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.pop();
        minStack.push(2);
        minStack.push(3);
        assert(minStack.min() == 2);
    }
    
    @Test
    public void secondTest() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.pop();
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
        assert(minStack.min() == 1);
    }
}
