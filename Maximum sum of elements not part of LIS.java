Question: Maximum sum of elements not part of LIS (Medium)

Given an array arr[] of positive integers, your task is to find the maximum possible sum of all elements that are not part of the Longest Increasing Subsequence (LIS).

Examples:

Input: arr[] = [4, 6, 1, 2, 3, 8]
Output: 10
Explanation: The elements which are not in LIS is 4 and 6.


Input: arr[] = [5, 4, 3, 2, 1]
Output: 14
Explanation: The elements which are not in LIS is 5, 4, 3 and 2.


Constraints:
1 ≤ arr.size() ≤ 10^3
1 ≤ arr[i] ≤ 10^5

Expected Complexities
Time Complexity: O(n log n)
Auxiliary Space: O(n)


Company Tags-> Flipkart

Topic Tags-> Dynamic Programming, Algorithms

// --------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n     = arr.length;                         // number of elements
        int total = 0;                                  // sum of all elements

        for (int v : arr) {
            total += v;
        }

        int[] dp       = new int[n];                    // dp[i] = length of LIS ending at i (min 1)
        int[] dpMinSum = new int[n];                    // dpMinSum[i] = min sum of an LIS of length dp[i] ending at i
        for (int i = 0; i < n; i++) {
            dp[i]       = 1;                            // each element alone is LIS length 1
            dpMinSum[i] = arr[i];                       // sum initialized to the element itself
        }

        int maxLIS    = 1;                              // global max LIS length
        int minLISsum = arr[0];                         // min sum among LIS of length maxLIS

        // build dp[] and dpMinSum[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    int currLen = dp[j] + 1;            // potential new LIS length
                    int currSum = dpMinSum[j] + arr[i]; // corresponding sum

                    if (currLen > dp[i]) {
                        dp[i]       = currLen;          // update LIS length at i
                        dpMinSum[i] = currSum;          // update min sum for this new length
                    } else if (currLen == dp[i]) {
                        // if same length, keep the smaller sum
                        dpMinSum[i] = Math.min(dpMinSum[i], currSum);
                    }
                }
            }
            // update global maxLIS and its min sum
            if (dp[i] > maxLIS) {
                maxLIS    = dp[i];
                minLISsum = dpMinSum[i];
            } else if (dp[i] == maxLIS) {
                minLISsum = Math.min(minLISsum, dpMinSum[i]);
            }
        }

        return total - minLISsum;                      // sum of elements not in any minimal‑sum LIS
    }
}