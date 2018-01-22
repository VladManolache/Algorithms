package algorithms.sequences.sweep_line;

import algorithms.common.Interval;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an interval list which are flying and landing time of the flight. 
 * How many sweep_line are on the sky at most? If landing and flying happens
 *  at the same time, we consider landing should happen at first.
 * 
 * Example:
 * For interval list
 * [
 *   [1,10],
 *   [2,3],
 *   [5,8],
 *   [4,7]
 * ]
 * 
 * @author Vlad Manolache
 */
public class NrOfAirplanes {
    
    public int getMaxPlaneCount(List<Interval> intervals) {
        
        // convert intervals into separate events.
        List<Event> events = new ArrayList<>();
        for (Interval i : intervals) {
            events.add(new Event(i.start, 1));
            events.add(new Event(i.end, 0));
        }
 
        // sort by start interval
        Collections.sort(events, Event.EventComparator);
        
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Event event : events) {
            if (event.flag == 1) {
                count++;
            }
            else {
                count--;
            }
            max = Math.max(max, count);
        }
       
        return max;
    }
    
}
