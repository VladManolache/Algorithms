/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursion.permutations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Vlad Manolache
 */
public class PowerSetGeneratorTest {
    
    @Test
    void easyTest() {
        ArrayList<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("c");
        int expectedResultSetSize = (int) Math.pow(2, set.size());

        PowerSetGenerator<String> powerSetGenerator = new PowerSetGenerator<>();
        HashSet<List<String>> result1 = powerSetGenerator.buildPowerSet_recursion(set);
        HashSet<List<String>> result2 = powerSetGenerator.buildPowerSet_backtracking(set);
        HashSet<List<String>> result3 = powerSetGenerator.buildPowerSet_binary(set);

        assert(result1.size() == expectedResultSetSize);
        assert(result2.size() == expectedResultSetSize);
        assert(result3.size() == expectedResultSetSize);
    }
    
    @Test
    void mediumTest() {
        ArrayList<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("f");
        int expectedResultSetSize = (int) Math.pow(2, set.size());

        PowerSetGenerator<String> powerSetGenerator = new PowerSetGenerator<>();
        HashSet<List<String>> result1 = powerSetGenerator.buildPowerSet_recursion(set);
        HashSet<List<String>> result2 = powerSetGenerator.buildPowerSet_backtracking(set);
        HashSet<List<String>> result3 = powerSetGenerator.buildPowerSet_binary(set);

        assert(result1.size() == expectedResultSetSize);
        assert(result2.size() == expectedResultSetSize);
        assert(result3.size() == expectedResultSetSize);
    }

    @Test
    void duplicateTest() {
        ArrayList<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        set.add("e");
        set.add("f");

        PowerSetGenerator<String> powerSetGenerator = new PowerSetGenerator<>();
        HashSet<List<String>> result1 = powerSetGenerator.buildPowerSet_recursion(set);
        HashSet<List<String>> result2 = powerSetGenerator.buildPowerSet_backtracking(set);
        HashSet<List<String>> result3 = powerSetGenerator.buildPowerSet_binary(set);

        assert(result1.size() == 48);
        assert(result2.size() == 48);
        assert(result3.size() == 48);
    }

    @Test
    void multipleDuplicatesTest() {
        ArrayList<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("a");
        set.add("d");
        set.add("a");
        set.add("a");

        PowerSetGenerator<String> powerSetGenerator = new PowerSetGenerator<>();
        HashSet<List<String>> result1 = powerSetGenerator.buildPowerSet_recursion(set);
        HashSet<List<String>> result2 = powerSetGenerator.buildPowerSet_backtracking(set);
        HashSet<List<String>> result3 = powerSetGenerator.buildPowerSet_binary(set);

        assert(result1.size() == 20);
        assert(result2.size() == 20);
        assert(result3.size() == 20);
    }

    @Test
    void powerTestV3Only() {
        ArrayList<String> set = new ArrayList<>();
        set.add("a"); set.add("b"); set.add("c"); set.add("d"); set.add("e"); set.add("f");
        set.add("g"); set.add("h"); set.add("i"); set.add("j"); set.add("k"); set.add("l");
        set.add("m"); set.add("n"); set.add("o"); set.add("p"); set.add("q"); set.add("r");

        int expectedResultSetSize = (int) Math.pow(2, set.size());

        PowerSetGenerator<String> powerSetGenerator = new PowerSetGenerator<>();
        HashSet<List<String>> result3 = powerSetGenerator.buildPowerSet_binary(set);
        assert(result3.size() == expectedResultSetSize);
    }
}
