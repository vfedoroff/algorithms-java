package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortedArraySquaresTest {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0, right = arr.length - 1;
        int index = arr.length - 1;
        while (left < right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[index] = leftSquare;
                left++;
            } else {
                squares[index] = rightSquare;
                right--;
            }
            index--;
        }
        return squares;
    }

    @Test
    void testMakeSquares(){
        Assertions.assertArrayEquals(new int[]{0, 1, 4, 4, 9},makeSquares(new int[]{-2, -1, 0, 2, 3}));
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 4, 9},makeSquares(new int[]{-3, -1, 0, 1, 2}));
    }
}
