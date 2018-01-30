package algorithms.recursion.dynamic_programming.grid_unique_paths;

import org.junit.jupiter.api.Test;

class GridUniquePathsTest {

    @Test
    void testGrid2by2() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int expectedResult = 2;
        assert(gridUniquePaths.countPaths_recursive(2, 2) == expectedResult);
        assert(gridUniquePaths.countPaths_dynamic(2, 2) == expectedResult);
    }

    @Test
    void testGrid3by4() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int expectedResult = 10;
        assert(gridUniquePaths.countPaths_recursive(3, 4) == expectedResult);
        assert(gridUniquePaths.countPaths_dynamic(3, 4) == expectedResult);
    }

    @Test
    void testGrid15by10() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int expectedResult = 817190;
        assert(gridUniquePaths.countPaths_recursive(15, 10) == expectedResult);
        assert(gridUniquePaths.countPaths_dynamic(15, 10) == expectedResult);
    }
}
