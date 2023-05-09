import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        int minValue = 0;
        int maxValue = 10000;

        int numIterations = 100;

        for (int size : sizes) {
            int[] arr = RandomArrayGenerator.generateRandomArray(size, minValue, maxValue);

            Arrays.sort(arr);

            int target = arr[(int) (Math.random() * size)];

            long linearSearchTime = 0;
            long binarySearchTime = 0;

            for (int i = 0; i < numIterations; i++) {
                long startTime = System.nanoTime();
                int index = linearSearch(arr, target);
                long endTime = System.nanoTime();
                linearSearchTime += endTime - startTime;
            }

            for (int i = 0; i < numIterations; i++) {
                long startTime = System.nanoTime();
                int index = binarySearch(arr, target);
                long endTime = System.nanoTime();
                binarySearchTime += endTime - startTime;
            }

            linearSearchTime /= numIterations;
            binarySearchTime /= numIterations;

            System.out.println("Size: " + size);
            System.out.println("Target: " + target);
            System.out.println("Linear Search Time: " + linearSearchTime + " nanoseconds");
            System.out.println("Binary Search Time: " + binarySearchTime + " nanoseconds");
            System.out.println();
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if
            (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


