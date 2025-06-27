// Question: Mobile numeric keypad (medium)

// There is a standard numeric keypad on a mobile phone. You can press the current button or any button that is directly above, below, to the left, or to the right of it. For example, if you press 5, then pressing 2, 4, 6, or 8 is allowed. However, diagonal movements and pressing the bottom row corner buttons (* and #) are not allowed.


// Given an integer n, determine how many unique sequences of length n can be formed by pressing buttons on the keypad, starting from any digit.

// Examples :

// Input: n = 1
// Output: 10
// Explanation: Possible 1-digit numbers follow keypad moves - From 0 → 0, 1 → 1, 2 → 2 and so on, total 10 valid combinations are possible.


// Input: n = 2
// Output: 36
// Explanation: Possible 2-digit numbers follow keypad moves -
// From 0 → 00, 08 (2), 
// From 1 → 11, 12, 14 (3),
// From 3 → 33, 32, 36 (3), and so on,
// total 36 valid combinations are possible.


// Constraints:
// 1 ≤ n ≤ 15

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Company Tags -> Flipkart, Microsoft, MAQ Software, Sprinklr

// Topic Tags -> Dynamic Programming, Algorithms, Mathematical

// Related Interview Experiences-> Sprinklr Interview Experience Set 2 On Campus, Microsoft Interview Experience Set 53, Flipkart Interview Set 11, Flipkart Interview Experience For Sde 2

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    int[][][] dp = new int[4][3][16];

    int solve(int i, int j, int n) {
        // invalid or forbidden cells (* and #)
        if (i < 0 || i >= 4 || j < 0 || j >= 3 ||
            (i == 3 && (j == 0 || j == 2))) {
            return 0;
        }

        // base case: sequence length 1 → only the current key
        if (n == 1) {
            return 1;
        }

        // return cached result if available
        if (dp[i][j][n] != -1) {
            return dp[i][j][n];
        }

        int result = 0;
        // stay in place
        result += solve(i, j, n - 1) +
                  // move up
                  solve(i - 1, j, n - 1) +
                  // move left
                  solve(i, j - 1, n - 1) +
                  // move right
                  solve(i, j + 1, n - 1) +
                  // move down
                  solve(i + 1, j, n - 1);

        // cache and return
        return dp[i][j][n] = result;
    }
    
    public int getCount(int n) {
        int count = 0;

        // initialize memo table
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 16; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        // iterate over all starting cells
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                count += solve(i, j, n);
            }
        }
        return count;
    }
}