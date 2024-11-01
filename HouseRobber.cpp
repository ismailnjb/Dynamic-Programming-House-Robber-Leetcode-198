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

int main() {
    vector<int> arr = {5, 3, 2, 4, 2, 4};

    int maxSum = maxNonAdjacentSum(arr);

    cout << "Maximum non-adjacent sum: " << maxSum << endl;

    return 0;
}
