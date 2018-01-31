package algorithms.sequences.sweep_line.merge_intervals;

import algorithms.common.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Vlad Manolache
 */
public class MergeIntervalsTest {
    
    @Test
    void testMergeIntervals() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> results = mergeIntervals.merge(intervals);

        List<Interval> desiredResults = new ArrayList<>();
        desiredResults.add(new Interval(1, 6));
        desiredResults.add(new Interval(8, 10));
        desiredResults.add(new Interval(15, 18));

        for (Interval result : results) {
            System.out.println(result.start + " " + result.end);
        }
        
        assert(equals(results, desiredResults));
    }

    @Test
    void testMergeIntervalsAdvanced() {
        MergeIntervals mergeIntervals = new MergeIntervals();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(4, 9));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        List<Interval> results = mergeIntervals.merge(intervals);

        List<Interval> desiredResults = new ArrayList<>();
        desiredResults.add(new Interval(1, 2));
        desiredResults.add(new Interval(3, 10));
        desiredResults.add(new Interval(12, 16));

        for (Interval result : results) {
            System.out.println(result.start + " " + result.end);
        }

        assert(equals(results, desiredResults));
    }
    
    private static <T> boolean equals(Collection<T> lhs, Collection<T> rhs) {
        return lhs.size( ) == rhs.size() && lhs.containsAll(rhs)  && rhs.containsAll(lhs);
    }
}
