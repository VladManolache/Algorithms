package algorithms.permutations;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Vlad Manolache
 */
public class RepresentNCentsGenerator {
        
    public int generatePermutations(int cents) {
        HashMap<Integer, Integer> values = new HashMap<>();
        ArrayList<HashMap<Integer, Integer>> solutions = new ArrayList();
        values.put(1, 0);
        values.put(5, 0);
        values.put(10, 0);
        values.put(25, 0);
       
        buildPermutations(solutions, values, cents);
        return solutions.size();
    }
    
    private void buildPermutations(ArrayList<HashMap<Integer, Integer>> solutions, HashMap<Integer, Integer> values, int cents) {
        
        if (getSum(values) == cents) {

            boolean contains = false;
            for ( int i = 0; i < solutions.size(); i++ ) { 
                HashMap<Integer, Integer> solution = solutions.get(i);
                if ( solution.get(1).equals(values.get(1)) && 
                        solution.get(5).equals(values.get(5)) &&
                        solution.get(10).equals(values.get(10)) &&
                        solution.get(25).equals(values.get(25)) ) {
                    contains = true;
                    break;
                }
            }
             
            if ( !contains ) {
                solutions.add(new HashMap<>(values));
            }

            return;
        }
        
        if (getSum(values) + 1 <= cents) {
            values.put(1, values.get(1) + 1);
            buildPermutations(solutions, values, cents);
            values.put(1, values.get(1) - 1);
        }
        
        if (getSum(values) + 5 <= cents) {
            values.put(5, values.get(5) + 1);
            buildPermutations(solutions, values, cents);
            values.put(5, values.get(5) - 1);
        }
        
        if (getSum(values) + 10 <= cents) {
            values.put(10, values.get(10) + 1);
            buildPermutations(solutions, values, cents);
            values.put(10, values.get(10) - 1);
        }
        
        if (getSum(values) + 25 <= cents) {
            values.put(25, values.get(25) + 1);
            buildPermutations(solutions, values, cents);
            values.put(25, values.get(25) - 1);
        }
    }
    
    private int getSum(HashMap<Integer, Integer> values) {
        return (values.get(1) * 1) + 
                (values.get(5) * 5) + 
                (values.get(10) * 10) + 
                (values.get(25) * 25);
    }
    
}
