package algorithms.sequences.sweep_line;

import java.util.Comparator;

/**
 *
 * @author Vlad Manolache
 */
class Event {
    int time;
    int flag;
    
    public Event(int inTime, int inFlag) {
        time = inTime;
        flag = inFlag;
    }
    
    public static Comparator<Event> EventComparator = (a, b) -> {
        if (a.time == b.time) {
            return a.flag - b.flag;
        }
        return a.time - b.time;
    };
}

