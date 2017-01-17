/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author user
 */
public class PowerSetGeneratorTest {
    
    @Test
    public void easyTest() {
        ArrayList<String> set = new ArrayList();
        set.add("a");
        set.add("b");
        set.add("c");
        
        PowerSetGenerator powerSet = new PowerSetGenerator();
        HashSet<List<String>> result = powerSet.getPowerSet(set);
         
        assert(result.size() == 8);
    }
    
    @Test
    public void mainTest() {
        ArrayList<String> set = new ArrayList();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("f");

        PowerSetGenerator powerSet = new PowerSetGenerator();
        HashSet<List<String>> result = powerSet.getPowerSet(set);
         
        assert(result.size() == 64);
    }
    
}
