package algorithms.sequences.sweep_line.nr_of_airplanes;

import algorithms.common.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * @author Vlad Manolache
 */
public class NrOfAirplanesTest {
    
    @Test
    void mainTest() {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(4, 7));

        NrOfAirplanes nrOfAirplanes = new NrOfAirplanes();
        assert(nrOfAirplanes.getMaxPlaneCount(intervals) == 3);
    }
    
}
