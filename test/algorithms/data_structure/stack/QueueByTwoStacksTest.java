package algorithms.data_structure.stack;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class QueueByTwoStacksTest {
    
    @Test
    void mainTest() {
        QueueByTwoStacks queueByTwoStacks = new QueueByTwoStacks();
        queueByTwoStacks.push(1);
        queueByTwoStacks.pop();
        queueByTwoStacks.push(2);
        queueByTwoStacks.push(3);
        assert(queueByTwoStacks.pop() == 2);
    }
    
}
