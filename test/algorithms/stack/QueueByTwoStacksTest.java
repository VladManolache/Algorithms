package algorithms.stack;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class QueueByTwoStacksTest {
    
    @Test
    public void mainTest() {
        QueueByTwoStacks queueByTwoStacks = new QueueByTwoStacks();
        queueByTwoStacks.push(1);
        queueByTwoStacks.pop();
        queueByTwoStacks.push(2);
        queueByTwoStacks.push(3);
        assert(queueByTwoStacks.pop() == 2);
    }
    
}
