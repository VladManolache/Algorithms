package algorithms.sequences.two_pointers.other.trap_rain_water;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class TrapRainWaterTest {
    
    @Test
    void mainTest_V1() {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrapRainWater trapRainWater = new TrapRainWater();
        assert(trapRainWater.getTrappedRainWater_V1(heights) == 6);
    }
    
    @Test
    void mainTest_V2() {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrapRainWater trapRainWater = new TrapRainWater();
        assert(trapRainWater.getTrappedRainWater_V2(heights) == 6);
    }
    
    @Test
    void secondaryTest_V1() {
        int[] heights = {1,0,3,1,2,3,2,4,5,2,3};
        TrapRainWater trapRainWater = new TrapRainWater();
        assert(trapRainWater.getTrappedRainWater_V1(heights) == 6);
    }
    
    @Test
    void secondaryTest_V2() {
        int[] heights = {1,0,3,1,2,3,2,4,5,2,3};
        TrapRainWater trapRainWater = new TrapRainWater();
        assert(trapRainWater.getTrappedRainWater_V2(heights) == 6);
    }
    
}
