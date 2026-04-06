import java.util.Arrays;

public class RiskThresholdLookup {

    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear Not Found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Exact Match at index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Insertion Point: " + low);
        System.out.println("Comparisons: " + comparisons);
        return low;
    }

    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        int target = 30;

        linearSearch(risks, target);

        Arrays.sort(risks);

        insertionPoint(risks, target);

        int f = floor(risks, target);
        int c = ceiling(risks, target);

        System.out.println("Floor: " + f);
        System.out.println("Ceiling: " + c);
    }
}