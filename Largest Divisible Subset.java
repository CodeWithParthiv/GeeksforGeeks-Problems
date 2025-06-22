// Question: Largest Divisible Subset (medium)

// Given an array arr[] of distinct positive integers. Your task is to find the largest subset such that for every pair of elements (x, y) in the subset, either x divides y or y divides x.
// Note : If multiple subsets of the same maximum length exist, return the one that is lexicographically greatest, after sorting the subset in ascending order.

// Examples:

// Input: arr[] = [1, 16, 7, 8, 4]
// Output: [1, 4, 8, 16]
// Explanation: The largest divisible subset is [1, 4, 8, 16], where each element divides the next one. This subset is already the lexicographically greatest one.


// Input: arr[] = [2, 4, 3, 8]
// Output: [2, 4, 8]
// Explanation: The largest divisible subset is [2, 4, 8], where each element divides the next one. This subset is already the lexicographically greatest one.


// Constraint:
// 1 ≤ arr.size() ≤ 10^3
// 1  ≤ arr[i] ≤ 10^9

// Expected Complexities
// Time Complexity: O(n^2)
// Auxiliary Space: O(n)

// Company Tags-> Bloomberg, Facebook, Adobe, Google, Amazon, Apple, Microsoft, Yahoo


// --------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Memoization table to store the best subsets for each state (idx, prev_idx + 1)
    private ArrayList<ArrayList<ArrayList<Integer>>> dp;

    // Helper function for recursion with memoization
    private ArrayList<Integer> solve(int idx, int[] arr, int prev_idx) {
        // Base case: if idx is out of bounds, return an empty list
        if (idx == arr.length) {
            return new ArrayList<>();
        }

        // If already computed, return the result from dp
        ArrayList<Integer> cached = dp.get(idx).get(prev_idx + 1);
        if (!cached.isEmpty()) {
            return new ArrayList<>(cached);
        }

        // Option 1: Take arr[idx] if divisible by arr[prev_idx]
        ArrayList<Integer> taken = new ArrayList<>();
        if (prev_idx == -1 || arr[idx] % arr[prev_idx] == 0) {
            ArrayList<Integer> nextTaken = solve(idx + 1, arr, idx);   // Recurse including current element
            taken = new ArrayList<>(nextTaken);                        // Clone to avoid mutation
            taken.add(0, arr[idx]);                                    // Prepend current element
        }

        // Option 2: Skip arr[idx]
        ArrayList<Integer> nextNotTake = solve(idx + 1, arr, prev_idx);
        ArrayList<Integer> not_take    = new ArrayList<>(nextNotTake); // Clone to avoid mutation

        // Compare and choose the larger or lexicographically greater subset
        ArrayList<Integer> result;
        if (not_take.size() > taken.size() ||
            (not_take.size() == taken.size() && lexCompare(not_take, taken) > 0)) {
            result = not_take;
        } else {
            result = taken;
        }

        // Memoize a clone of the result and return
        dp.get(idx).set(prev_idx + 1, new ArrayList<>(result));
        return result;
    }
    // Lexicographical comparison: returns >0 if a > b
    private int lexCompare(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }
    public ArrayList<Integer> largestSubset(int[] arr) {
        // Sort the array to ensure lexicographical order
        Arrays.sort(arr);
        int n = arr.length;

        // Initialize dp table of size n x (n+1)
        dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<Integer>> row = new ArrayList<>(n + 1);
            for (int j = 0; j <= n; j++) {
                row.add(new ArrayList<>());
            }
            dp.add(row);
        }

        // Start recursion with prev_idx = -1
        ArrayList<Integer> ans = solve(0, arr, -1);
        return ans;
    }
}