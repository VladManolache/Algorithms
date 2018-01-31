
package algorithms.sequences.three_pointers.sort_3colors;

/**
 *
 * @author Vlad Manolache
 */
public class Color {
    
    public enum Type {
        RED,
        WHITE,
        BLUE
    }
    
    private Type type;
    
    public Color(Type type) {
        this.type = type;
    } 
    
    public Type getColor() {
        return this.type;
    }
    
    public void setColor(Type type) {
        this.type = type;
    }
    
    public int compare(algorithms.sequences.three_pointers.sort_3colors.Color x) {
        if (getColor() == x.getColor()) {
            return 0;
        }
        else if (getColor().ordinal() < x.getColor().ordinal()) {
            return -1;
        } 
        
        return 1;
    }
}
