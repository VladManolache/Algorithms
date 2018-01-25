package algorithms.recursion.other;

import java.util.Stack;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle
 *  is to move the entire stack to another rod, obeying the following simple rules:
 * 1) Only one disk can be moved at a time.
 * 2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * 3) No disk may be placed on top of a smaller disk.
 *
 * Take an example for 2 disks:
 * Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
 * Step 1 : Shift first disk from 'A' to 'B'.
 * Step 2 : Shift second disk from 'A' to 'C'.
 * Step 3 : Shift first disk from 'B' to 'C'.
 *
 * The pattern here is:
 * Shift 'n-1' disks from 'A' to 'B'.
 * Shift last disk from 'A' to 'C'.
 * Shift 'n-1' disks from 'B' to 'C'.
 *
 * @author Vlad Manolache
 */
public class TowerOfHanoi {

    private static class IdentifiedStack<T> extends Stack<T> {
        String name;

        IdentifiedStack(String name) {
            this.name = name;
        }
    }

    public void solve(String[] source) {
        IdentifiedStack<String> initial = new IdentifiedStack<>("A");
        for (String value : source) {
            initial.push(value);
        }
        IdentifiedStack<String> tmp = new IdentifiedStack<>("B");
        IdentifiedStack<String> dest = new IdentifiedStack<>("C");
        solveProblem(initial.size(), initial, tmp, dest);
    }

    private void solveProblem(int n, IdentifiedStack<String> source, IdentifiedStack<String> helper, IdentifiedStack<String> destination) {
        if (n > 0) {
            // move n - 1 disks from source to auxiliary, so they are out of the way
            solveProblem(n - 1, source, destination, helper);

            // move the nth disk from source to target
            destination.push(source.pop());

            // Display our progress
            System.out.println("N: " + n + " | " + source.name + " -> " + destination.name);

            // move the n - 1 disks that we left on auxiliary onto target
            solveProblem(n - 1, helper, source, destination);
        }
    }
}
