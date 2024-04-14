import java.util.Arrays;

public class Main {

    // Function to find the maximum sum subsequence crossing the middle element
    private static int maxCrossingSum(int[] arr, int l, int m, int h, int[] resultIndices) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = m;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = m + 1;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        resultIndices[0] = maxLeft;
        resultIndices[1] = maxRight;
        
        return leftSum + rightSum;
    }

    // Function to find the maximum sum subsequence recursively
    private static int maxSumSubsequence(int[] arr, int l, int h, int[] resultIndices) {
        // Base Case: Only one element
        if (l == h) {
            resultIndices[0] = l;
            resultIndices[1] = h;
            return arr[l];
        }

        // Find middle point
        int m = (l + h) / 2;

        // Create arrays to hold the left and right subarray indices
        int[] leftIndices = new int[2];
        int[] rightIndices = new int[2];

        // Return maximum of the following three possible cases:
        // a) Maximum subsequence sum in left half
        // b) Maximum subsequence sum in right half
        // c) Maximum subsequence sum such that the subsequence crosses the midpoint
        return Math.max(Math.max(maxSumSubsequence(arr, l, m, leftIndices),
                                 maxSumSubsequence(arr, m + 1, h, rightIndices)),
                        maxCrossingSum(arr, l, m, h, resultIndices));
    }

    // Function to find and print the maximum sum subsequence
    public static void findMaxSumSubsequence(int[] arr) {
        int n = arr.length;
        int[] resultIndices = new int[2];
        int maxSum = maxSumSubsequence(arr, 0, n - 1, resultIndices);
        int leftIndex = resultIndices[0];
        int rightIndex = resultIndices[1];

        System.out.println("Maximum Sum Subsequence: " + maxSum);
        System.out.print("Subarray with Maximum Sum: ");
        for (int i = leftIndex; i <= rightIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] arr = {3, -6, 8, -3, -3, 6, -3, 5, -3, 2};
        System.out.println("Array: " + Arrays.toString(arr));
        findMaxSumSubsequence(arr);
    }
}
