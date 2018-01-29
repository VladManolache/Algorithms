package algorithms.sort;

import algorithms.common.Interval;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Priority: High
 * Companies: Google
 *
 * Description:
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example:
 * Given intervals => merged intervals:
 * [                     [
 *   [1, 3],               [1, 6],
 *   [2, 6],      =>       [8, 10],
 *   [8, 10],              [15, 18]
 *   [15, 18]            ]
 * ]
 * 
 * @author Vlad Manolache
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        intervals.sort(Comparator.comparingInt(a -> a.start));
        
        List<Interval> result = new ArrayList<>();
        Interval last = intervals.get(0);
        Interval current;

        for (int i = 1; i < intervals.size(); i++) {
            current = intervals.get(i);
            if (last.end > current.start) {
                last.end = Math.max(last.end, current.end);

            } else if (last.end < current.start) {
                result.add(last);
                last = current;
            }
        }
        result.add(last);
        
        return result;
    }
    
}
