package algorithms.data_structure.array.plusone;

import java.util.ArrayList;

/**
 * Difficulty: Easy
 * Companies: Google
 * Notes: Need to carefully consider the input range.
 *
 * Given a non-negative number represented as an array of digits, add 1 to the number
 *  (increment the number represented by the digits).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 * If the vector has [1, 2, 3] the returned vector should be [1, 2, 4]
 *
 * @author Vlad Manolache
 */
public class PlusOne {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                A.remove(i--);
            }
            else {
                break;
            }
        }

        int current;
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            current = A.get(i) + carry;

            if (current < 10) {
                carry = 0;
            }
            else {
                current = 0;
                carry = 1;
            }
            A.set(i, current);
        }

        if (A.size() == 0) {
            A.add(1);
        }
        else if (carry == 1 && A.get(0) == 0) {
            ArrayList<Integer> aux = new ArrayList<>();
            aux.add(1);
            aux.addAll(A);
            A = aux;
        }

        return A;
    }

}
