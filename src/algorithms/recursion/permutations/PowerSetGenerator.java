package algorithms.recursion.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Power Set Power set P(S) of a set S is the set of all subsets of S.
 * For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.
 *
 * Idea - represent item in set using binary:
 * {} = 000 (Binary) = 0 (Decimal)
 * {a} = 100 = 4
 * {b} = 010 = 2
 * {c} = 001 = 1
 * {a, b} = 110 = 6
 * {a, c} = 101 = 5
 * {b, c} = 011 = 3
 * {a, b, c} = 111 = 7
 *
 * @author Vlad Manolache
 */
public class PowerSetGenerator<T> {

    public HashSet<List<T>> buildPowerSet_v1(List<T> list) {
        HashSet<List<T>> powerSet = new HashSet<>();
        generatePowerSet_v1(list, powerSet);
        return powerSet;
    }

    private void generatePowerSet_v1(List<T> list, HashSet<List<T>> powerSet) {
        if (list.size() > 0) {
            powerSet.add(list);
        }
        for (T currentListItem : list) {
            List<T> temp = new ArrayList<>(list);
            temp.remove(currentListItem);
            generatePowerSet_v1(temp, powerSet);
        }
    }

    public HashSet<List<T>> buildPowerSet_v2(List<T> list) {
        HashSet<List<T>> powerSet = new HashSet<>();
        List<T> currentList = new ArrayList<>();

        boolean[] used = new boolean[list.size()];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        generatePowerSet_v2(currentList, list, used, powerSet);
        return powerSet;
    }

    public HashSet<List<T>> buildPowerSet_v3(List<T> list) {
        HashSet<List<T>> powerSet = new HashSet<>();

        generatePowerSet_v3(list, powerSet);

        return powerSet;
    }

    private void generatePowerSet_v2(List<T> currentList, List<T> initialList, boolean[] used, HashSet<List<T>> powerSet) {
        // Add solution if valid.
        boolean contains = false;
        for (List<T> list : powerSet) {
            if (list.containsAll(currentList) && currentList.containsAll(list)) {
                contains = true;
                break;
            }
        }
        if (!contains && currentList.size() > 0) {
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
            generatePowerSet_v2(currentList, initialList, used, powerSet);

            // Backtracking ...
            currentList.remove(currentItem);
            used[i] = false;
        }
    }

    private void generatePowerSet_v3(List<T> list, HashSet<List<T>> powerSet) {
        int pow_set_size = (int) Math.pow(2, list.size());

        // Run from counter 000..0 to 111..1
        for (int counter = 0; counter < pow_set_size; counter++) {
            List<T> accumulator = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                // Check if jth bit in the counter is set.
                if ((counter & (1 << j)) != 0) {
                    accumulator.add(list.get(j));
                }
            }
            if (accumulator.size() > 0) {
                powerSet.add(accumulator);
            }
        }
    }
}
