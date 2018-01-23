package algorithms.recursion.dynamic_programming.triple_step;

/**
 * Q. A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *
 * S: We can approach this problem from the top down. On the very last hop, up to the nth step, the child could have
 * done either a single, double, or triple step hop.That is, the last move might have been a single step hop from step
 * n-1, a double step hop from step n-2, or a triple step hop from n-3.The total number of ways of reaching the last
 * step is therefore the sum of the number of ways of reaching each of the last three steps.
 *
 * Ref: http://littletechnical.blogspot.in/2013/06/staircase-with-n-steps-problems.html
 *
 * @author Vlad Manolache
 */
public class TripleStep {

    public int countWays(int N) {
        int[] solution = new int[N + 1];
        for (int i = 0; i < N; i++) {
            solution[i] = -1;
        }

        return execute_top_down(N, solution);
    }

    private int execute_top_down(int N, int[] solution) {
        if (N < 0) {
            return 0;
        }
        else if (N == 0) {
            return 1;
        }
        else if (solution[N] > 0) {
            return solution[N];
        }

        solution[N] = execute_top_down(N - 1, solution) +
                execute_top_down(N - 2, solution) +
                execute_top_down(N - 3, solution);
        return solution[N];
    }
}
