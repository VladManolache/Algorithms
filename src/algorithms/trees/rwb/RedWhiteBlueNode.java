
package algorithms.trees.rwb;

/**
 *
 * @author Vlad Manolache
 */
public class RedWhiteBlueNode {
    
    public enum Color {
        RED,
        WHITE,
        BLUE
    }
    
    private Color color;
    
    public RedWhiteBlueNode(Color color) {
        this.color = color;
    } 
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public int compare(RedWhiteBlueNode x) {
        if (getColor() == x.getColor()) {
            return 0;
        }
        else if (getColor().ordinal() < x.getColor().ordinal()) {
            return -1;
        } 
        
        return 1;
    }
}
