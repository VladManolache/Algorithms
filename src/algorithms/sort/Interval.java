package algorithms.sort;

/**
 *
 * @author user
 */
public class Interval {
    int start, end;
       
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if (!obj.getClass().equals(getClass())) return false;
        else if ( ((Interval) obj).start == start && 
                ( (Interval) obj).end == end ) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.start;
        hash = 61 * hash + this.end;
        return hash;
    }
    
}
