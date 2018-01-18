package algorithms.sort;

import algorithms.utils.Interval;
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
    public void testMergeIntervals() {
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
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).start + " " + results.get(i).end);
        }
        
        assert(equals(results, desiredResults));
    }
    
    static <T> boolean equals(Collection<T> lhs, Collection<T> rhs) {
        return lhs.size( ) == rhs.size() && lhs.containsAll(rhs)  && rhs.containsAll(lhs);
    }
}
