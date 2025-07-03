// Question: Longest Substring with K Uniques (Medium)

// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

// Note : If no such substring exists, return -1. 

// Examples:

// Input: s = "aabacbebebe", k = 3
// Output: 7
// Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.


// Input: s = "aaaa", k = 2
// Output: -1
// Explanation: There's no substring with 2 distinct characters.


// Input: s = "aabaaab", k = 2
// Output: 7
// Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.


// Constraints:
// 1 ≤ s.size() ≤ 10^5
// 1 ≤ k ≤ 26

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Company Tags-> Amazon, Google, SAP Labs

// Topic Tags-> two-pointer-algorithm, Hash, Strings, Map, Data Structures, Algorithms

// // --------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>(); // map to store frequency of chars in current window

        int i = 0;                                    // left pointer of window
        int j = 0;                                    // right pointer of window

        int result = -1;                              // store max length found

        while (j < n) {
            // include s.charAt(j) in window
            char cj = s.charAt(j);
            mp.put(cj, mp.getOrDefault(cj, 0) + 1);

            // if more than k distinct, shrink from left
            if (mp.size() > k) {
                char ci = s.charAt(i);
                mp.put(ci, mp.get(ci) - 1);         // decrement freq of s.charAt(i)
                if (mp.get(ci) == 0) {              // if freq becomes 0, remove from map
                    mp.remove(ci);
                }
                i++;                                // move left pointer
            }

            // if exactly k distinct, update result
            if (mp.size() == k) {
                result = Math.max(result, j - i + 1);
            }
            j++; // expand right pointer
        }

        return result;
    }
}

