// Question: Coin Piles (Medium)

// You are given an array arr[] of integers, where each element represents the number of coins in a pile. You are also given an integer k.
// Your task is to remove the minimum number of coins such that the absolute difference between the number of coins in any two updated piles is at most k.

// Note: You can also remove a pile by removing all the coins of that pile.

// Examples:

// Input: arr[] = [2, 2, 2, 2], k = 0
// Output: 0
// Explanation: For any two piles the difference in the number of coins is <= 0. So no need to remove any coin. 


// Input: arr[] = [1, 5, 1, 2, 5, 1], k = 3
// Output : 2
// Explanation: If we remove one coin each from both the piles containing 5 coins, then for any two piles the absolute difference in the number of coins is <= 3. 


// Constraints:
// 1 ≤ arr.size() ≤ 10^5
// 1 ≤ arr[i] ≤ 10^4
// 0 ≤ k ≤ 10^4

// Expected Complexities
// Time Complexity: O(n log n)
// Auxiliary Space: O(n)

// Company Tags
// Microsoft

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Custom upper_bound implementation (first index with value > target)
    private int upperBound(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;

        // Sort the array to process piles in increasing order
        Arrays.sort(arr);

        // Compute prefix sum array to calculate sum in range efficiently
        int[] prefix = new int[n];
        prefix[0]    = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int result = Integer.MAX_VALUE; // Store minimum coins to remove
        int prev   = 0;                 // Sum of coins to be removed from piles before index i

        for (int i = 0; i < n; i++) {
            // Find index of first element greater than arr[i] + k using binary search
            int idx = upperBound(arr, i, n, arr[i] + k);

            if (i > 0) {
                prev = prefix[i - 1]; // Coins to remove from all piles before i
            }

            // Coins to remove from all piles beyond idx that are > arr[i] + k
            int totalToRemove = prev + prefix[n - 1] - prefix[idx - 1] - (arr[i] + k) * (n - idx);

            // Update result with minimum coins to remove
            result = Math.min(result, totalToRemove);
        }

        return result;
    }
}