// Question: Lexicographically Largest String After K Deletions (medium)

// Given a string s consisting of lowercase English letters and an integer k, your task is to remove exactly k characters from the string. The resulting string must be the largest possible in lexicographical  order, while maintain the relative order of the remaining characters.

// Examples:
// Input: s = "ritz", k = 2
// Output: tz 
// Explaination: By removing two characters in all possible ways, we get: "ri", "rt", "rz", "it", "iz", and "tz". Among these, "tz" is lexicographically largest string.


// Input: s = "zebra", k = 3
// Output: zr 
// Explaination: Removing "e", "b", and "a" results in "zr", which is lexicographically largest string.


// Constraints:
// 1 ≤ s.size() ≤ 10^5
// 0  ≤  k < s.size()

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(n)

// Topic Tags -> Stack, Strings, Greedy, Data Structures

// --------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public String maxSubseq(String s, int k) {
        int           n        = s.length();
        int           toRemove = k;                   // number of characters we still need to remove
        StringBuilder result   = new StringBuilder(); // acts like a stack to build the answer

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // while we can remove characters, and the current character c is greater
            // than the last in result, pop to make result lexicographically larger
            while (result.length() > 0 && toRemove > 0 && c > result.charAt(result.length() - 1)) {
                result.deleteCharAt(result.length() - 1);
                toRemove--;
            }
            result.append(c); // include current character
        }

        // if we haven't removed enough (e.g., string was non-decreasing), trim from the end
        result.setLength(n - k);
        return result.toString();
    }
}