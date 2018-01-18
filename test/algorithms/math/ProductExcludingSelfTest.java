package algorithms.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 *
 * @author Vlad Manolache
 */
public class ProductExcludingSelfTest {

    @Test
    public void mainTest() {
        int[] X = {2, 4, 1, 6, 5, 3};
        ProductExcludingSelf productExcludingSelf = new ProductExcludingSelf();

        int[] result = productExcludingSelf.getProductExcludingSelf(X);
        assertArrayEquals(result, new int[]{360, 180, 720, 120, 144, 240});
    }
}
