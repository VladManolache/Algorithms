package algorithms.recursion.other;

import org.junit.jupiter.api.Test;

class TowerOfHanoiTest {

    @Test
    void test() {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        String[] values = new String[] { "A", "B", "C" };
        towerOfHanoi.solve(values);
    }

}
