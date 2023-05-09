import java.util.Random;

public class RandomArrayGenerator {
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return arr;
    }
}
