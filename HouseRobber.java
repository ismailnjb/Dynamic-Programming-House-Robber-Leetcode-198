

public class HouseRobber {

    // Function to find the maximum sum of non-adjacent elements
    public static int maxNonAdjacentSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        // Dynamic programming array
        int[] dp = new int[n];
        dp[0] = arr[0];  // Include the first element
        dp[1] = Math.max(arr[0], arr[1]);  // Maximum of first two elements

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }

        return dp[n - 1];  // Return the last element
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 2, 4};
        System.out.println("Maximum sum of non-adjacent elements: " + maxNonAdjacentSum(arr));  // Output should be 13
    }
}
