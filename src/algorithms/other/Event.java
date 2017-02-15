package algorithms.other;

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
    
    public static Comparator<Event> EventComparator = new Comparator<Event>() {
        @Override
        public int compare(Event a, Event b) {
            if (a.time == b.time) {
                return a.flag - b.flag;
            }
            return a.time - b.time;
        }
    };
}

