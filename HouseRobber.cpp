#include <iostream>
#include <vector>

using namespace std;


int maxNonAdjacentSum(const vector<int>& nums) {
    int prev1 = 0, prev2 = 0;
    for (int n : nums) {
        int current = max(n + prev1, prev2);
        prev1 = prev2;
        prev2 = current;
    }
    return prev2;
}

int maxNonAdjacentSumTabulation(const vector<int>& arr) {
    // Edge cases: empty array or single element array
    if (arr.empty()) return 0;
    if (arr.size() == 1) return arr[0];

    // Initialize dp vector
    vector<int> dp(arr.size());
    
    // Base cases
    dp[0] = arr[0];
    dp[1] = max(arr[0], arr[1]);

    // Fill the dp vector
    for (size_t i = 2; i < arr.size(); i++) {
        dp[i] = max(arr[i] + dp[i - 2], dp[i - 1]);
    }
    
    // The last element in dp vector holds the result
    return dp.back();
}

int main() {
    vector<int> arr = {5, 3, 2, 4, 2, 4};


    cout << "Maximum non-adjacent sum: " << maxNonAdjacentSum(arr) << endl;
    cout << "Max non-adjacent sum (tabulation): " << maxNonAdjacentSumTabulation(arr) << endl;  // Output should be 13
   

    return 0;
}
