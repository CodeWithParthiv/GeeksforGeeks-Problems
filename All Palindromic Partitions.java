// Question: All Palindromic Partitions (medium)

// Given a string s, find all possible ways to partition it such that every substring in the partition is a palindrome.

// Examples:

// Input: s = "geeks"
// Output: [[g, e, e, k, s], [g, ee, k, s]]
// Explanation: [g, e, e, k, s] and [g, ee, k, s] are the only partitions of "geeks" where each substring is a palindrome.

// Input: s = "abcba"
// Output: [[a, b, c, b, a], [a, bcb, a], [abcba]]
// Explanation: [a, b, c, b, a], [a, bcb, a] and [abcba] are the only partitions of "abcba" where each substring is a palindrome.

// Constraints:
// 1 ≤ s.size() ≤ 20

// Expected Complexities
// Time Complexity: O(2^n * n)
// Auxiliary Space: O(2^n * n)

// Company Tags -> Amazon, Microsoft, 


// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Function to check if a substring s[l..r] is a palindrome
    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false; // Return false if characters at both ends don't match
            }
            l++;              // Move left pointer forward
            r--;              // Move right pointer backward
        }
        return true;          // All characters matched, hence it's a palindrome
    }

    // Recursive backtracking to explore all palindromic partitions
    void backtrack(int idx,
                   String s,
                   ArrayList<String> curr,
                   ArrayList<ArrayList<String> > result) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(curr)); // Add current partition to result if end of string is reached
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            // Check if s[idx..i] is a palindrome
            if (isPalindrome(s, idx, i)) {
                // If yes, add it to the current path
                curr.add(s.substring(idx, i + 1));

                // Recurse for the remaining substring
                backtrack(i + 1, s, curr, result);

                // Backtrack: remove last added substring and try next possibility
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    // Entry function to initiate backtracking
    public ArrayList<ArrayList<String> > palinParts(String s) {
        ArrayList<ArrayList<String> > result = new ArrayList<>(); // Final result of all partitions
        ArrayList<String>             curr   = new ArrayList<>(); // Current partition path

        backtrack(0, s, curr, result);                            // Start from index 0
        return result;
    }
}