package algorithms.recursion.permutations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Power Set Power set P(S) of a set S is the set of all subsets of S.
 * For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.
 *
 * Solution
 * Given the length of the set n, each subset can be represent as follows:
 * {} = 000 (Binary) = 0 (Decimal)
 * {a} = 100 = 4
 * {b} = 010 = 2
 * {c} = 001 = 1
 * {a, b} = 110 = 6
 * {a, c} = 101 = 5
 * {b, c} = 011 = 3
 * {a, b, c} = 111 = 7
 * We can then iterate over all values including from 0 to 2^n (representing all combinations of 0 and 1)
 *  and add each combination to the list.
 *
 * Note - Duplicate input values are supported, but each result subset contains distinct elements.
 *
 * @author Vlad Manolache
 */
public class PowerSetGenerator<T> {

    public HashSet<List<T>> buildPowerSet_recursion(List<T> list) {
        HashSet<List<T>> powerSet = new HashSet<>();
        generatePowerSet_recursion(list, powerSet);
        return powerSet;
    }

    private void generatePowerSet_recursion(List<T> list, HashSet<List<T>> powerSet) {
        powerSet.add(list);
        for (T currentListItem : list) {
            List<T> temp = new ArrayList<>(list);
            temp.remove(currentListItem);
            generatePowerSet_recursion(temp, powerSet);
        }
    }

    public HashSet<List<T>> buildPowerSet_backtracking(List<T> list) {
        HashSet<List<T>> powerSet = new HashSet<>();
        List<T> currentList = new ArrayList<>();

        boolean[] used = new boolean[list.size()];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        generatePowerSet_backtracking(currentList, list, used, powerSet);
        return powerSet;
    }

    public HashSet<List<T>> buildPowerSet_binary(List<T> list) {
        HashSet<List<T>> powerSet = new HashSet<>();

        generatePowerSet_binary(list, powerSet);

        return powerSet;
    }

    private void generatePowerSet_backtracking(List<T> currentList, List<T> initialList, boolean[] used, HashSet<List<T>> powerSet) {
        // Add solution if valid.
        currentList.sort(Comparator.comparing(Object::toString));
        if (!powerSet.contains(currentList)) {
            // Important - save a new list to avoid having it altered subsequently.
            powerSet.add(new ArrayList<>(currentList));
        }

        for (int i = 0; i < initialList.size(); i++) {
            // Decide if we should continue.
            T currentItem = initialList.get(i);
            if (used[i]) {
                continue;
            }

            // Make current move.
            currentList.add(currentItem);
            used[i] = true;

            // Make next moves.
            generatePowerSet_backtracking(currentList, initialList, used, powerSet);

            // Backtracking ...
            currentList.remove(currentItem);
            used[i] = false;
        }
    }

    private void generatePowerSet_binary(List<T> initialList, HashSet<List<T>> powerSet) {
        int pow_set_size = (int) Math.pow(2, initialList.size());

        // Run from counter 000..0 to 111..1
        for (int counter = 0; counter < pow_set_size; counter++) {
            List<T> accumulator = new ArrayList<>();
            for (int j = 0; j < initialList.size(); j++) {
                // Check if j-th bit in the counter is set.
                if ((counter & (1 << j)) != 0) {
                    accumulator.add(initialList.get(j));
                }
            }
            accumulator.sort(Comparator.comparing(Object::toString));
            if (!powerSet.contains(accumulator)) {
                powerSet.add(accumulator);
            }
        }
    }
}
