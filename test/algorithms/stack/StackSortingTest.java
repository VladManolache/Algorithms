package algorithms.stack;

import java.util.Stack;
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class StackSortingTest {
    
    @Test
    public void mainTest_V1() {
        Stack<Integer> stack = new Stack();
        stack.add(4);
        stack.add(10);
        stack.add(15);
        stack.add(5);
        stack.add(2);
        stack.add(3);
        stack.add(1);
         
        Stack<Integer> sortedStack = new Stack();
        sortedStack.add(15);
        sortedStack.add(10);
        sortedStack.add(5); 
        sortedStack.add(4);
        sortedStack.add(3);
        sortedStack.add(2);
        sortedStack.add(1);
        
        boolean areEqual = true;
        StackSorting stackSorting = new StackSorting();
        stackSorting.stackSort(stack); 
        for (int i = 0; i < stack.size(); i++) {
            if (!stack.get(i).equals(sortedStack.get(i))) {
                areEqual = false;
            }
        }
                
        assert(areEqual);
    }
    
}
