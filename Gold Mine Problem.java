// Question: Gold Mine Problem (Medium)

// Given a gold mine called mat[][]. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially, the miner can start from any row in the first column. From a given cell, the miner can move -

// to the cell diagonally up towards the right
// to the right
// to the cell diagonally down towards the right
// Find out the maximum amount of gold that he can collect until he can no longer move.

// Examples:

// Input: mat[][] = [[1, 3, 3], [2, 1, 4], [0, 6, 4]]
// Output: 12
// Explaination: The path is (1, 0) -> (2, 1) -> (2, 2). Total gold collected is 2 + 6 + 4 = 12.


// Input: mat[][] = [[1, 3, 1, 5], [2, 2, 4, 1], [5, 0, 2, 3], [0, 6, 1, 2]]
// Output: 16
// Explaination: The path is (2, 0) -> (3, 1) -> (2, 2) -> (2, 3) or (2, 0) -> (1, 1) -> (1, 2) -> (0, 3). 
// Total gold collected is (5 + 6 + 2 + 3) or (5 + 2 + 4 + 5) = 16.


// Input: mat[][] = [[1, 3, 3], [2, 1, 4], [0, 7, 5]]
// Output: 14
// Explaination: The path is (1,0) -> (2,1) -> (2,2). Total gold collected is 2 + 7 + 5 = 14.


// Constraints:
// 1 ≤ mat.size(), mat[0].size() ≤ 500
// 0 ≤ mat[i][j] ≤ 100

// Expected Complexities
// Time Complexity: O(n * m)
// Auxiliary Space: O(1)


// Company Tags-> Flipkart, Amazon, Samsung

// Topic Tags-> Dynamic Programming, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    // helper that returns max gold from cell (i, j)
    private int solve(int i, int j, int[][] mat, int[][] dp) {
        int n = mat.length;
        int m = mat[0].length;

        // base case: out of bounds or beyond last column
        if (i < 0 || i >= n || j >= m) {
            return 0;
        }

        // if already computed, reuse it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // move to right-up cell
        int rightUp = solve(i - 1, j + 1, mat, dp);
        // move to right cell
        int right = solve(i, j + 1, mat, dp);
        // move to right-down cell
        int rightDown = solve(i + 1, j + 1, mat, dp);

        // cache and return the best of three moves plus current gold
        return dp[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
    }
    
    public int maxGold(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int result = 0;
        // initialize dp table to -1 (uncomputed)
        int[][] dp = new int[501][501];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // try starting from each row in first column
        for (int i = 0; i < n; i++) {
            result = Math.max(result, solve(i, 0, mat, dp));
        }
        return result;
    }
}