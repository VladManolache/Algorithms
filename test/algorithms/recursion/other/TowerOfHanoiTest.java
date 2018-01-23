package algorithms.recursion.other;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TowerOfHanoiTest {

    @Test
    void test() {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        Stack<String> initial = new Stack<>();
        initial.push("A"); initial.push("B"); initial.push("C");
        towerOfHanoi.solve(initial);
    }

}
