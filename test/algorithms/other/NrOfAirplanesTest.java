package algorithms.other;

import algorithms.utils.Interval;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Vlad Manolache
 */
public class NrOfAirplanesTest {
    
    @Test
    public void mainTest() {
        ArrayList<Interval> intervals = new ArrayList();
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(4, 7));

        NrOfAirplanes nrOfAirplanes = new NrOfAirplanes();
        assert(nrOfAirplanes.getMaxPlaneCount(intervals) == 3);
    }
    
}
