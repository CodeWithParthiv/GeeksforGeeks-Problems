// Question: Substrings of length k with k-1 distinct elements (Medium)

// Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.

// Examples:

// Input: s = "abcc", k = 2
// Output: 1
// Explaination: Possible substring of length k = 2 are,
// ab : 2 distinct characters
// bc : 2 distinct characters
// cc : 1 distinct characters
// Only one valid substring so, count is equal to 1.


// Input: "aabab", k = 3
// Output: 3
// Explaination: Possible substring of length k = 3 are, 
// aab : 2 distinct charcters
// aba : 2 distinct characters
// bab : 2 distinct characters
// All these substring are valid so, the total count is equal to 3.


// Constrains:
// 1 ≤ s.size() ≤ 10^5
// 2 ≤ k ≤ 27

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Company Tags-> Amazon

// Topic Tags-> sliding-window, Strings, Data Structures, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int substrCount(String s, int k) {
        int n      = s.length();
        int result = 0;

        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[26]; // reset frequency array for each substring

            for (int j = i; j < i + k; j++) {
                freq[s.charAt(j) - 'a']++; // count frequency of characters in current substring
            }

            int count = 0;
            for (int l = 0; l < 26; l++) {
                if (freq[l] > 0) {
                    count++; // count distinct characters
                }
            }

            if (count == k - 1) {
                result++; // valid substring
            }
        }

        return result;
    }
}