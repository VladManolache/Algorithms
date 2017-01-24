package algorithms.sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Vlad Manolache
 */
public class PowerSetGenerator {
    
     
    public HashSet<List<String>> getPowerSet(List<String> list) {
        HashSet<List<String>> powerSet = new HashSet<>();
        buildPowerSet_v1(list, powerSet);
        return powerSet;
    }
    
    private void buildPowerSet_v1(List<String> list, HashSet<List<String>> powerSet) {
        powerSet.add(list);
        for (String currentListItem : list) {
            List<String> temp = new ArrayList<>(list);
            temp.remove(currentListItem);
            buildPowerSet_v1(temp, powerSet);
        }  
    }
    
}
