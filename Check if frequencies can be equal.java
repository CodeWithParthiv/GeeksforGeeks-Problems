// Question: Check if frequencies can be equal (medium)

// Given a string s consisting only lowercase alphabetic characters, check whether it is possible to remove at most one character such that the  frequency of each distinct character in the string becomes same. Return true if it is possible; otherwise, return false.

// Examples:

// Input: s = "xyyz"
// Output: true 
// Explanation: Removing one 'y' will make frequency of each distinct character to be 1.


// Input: s = "xyyzz"
// Output: true
// Explanation: Removing one 'x' will make frequency of each distinct character to be 2.


// Input: s = "xxxxyyzz"
// Output: false
// Explanation: Frequency can not be made same by removing at most one character.


// Constraints:
// 1 ≤ s.size() ≤ 10^5

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Company Tags -> Zoho

// Topic Tags -> Hash, Strings, Data Structures

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    boolean sameFreq(String s) {
        int[] freq = new int[26];  // Count frequency of each character (a-z)

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;  // Increment corresponding index
        }

        int maxFreqValue   = Integer.MIN_VALUE; // Track the maximum frequency
        int maxFreqCounter = 0;                 // Count how many characters have maxFreqValue
        int minFreqValue   = Integer.MAX_VALUE; // Track the minimum frequency
        int minFreqCounter = 0;                 // Count how many characters have minFreqValue

        for (int f : freq) {
            if (f == 0) {
                continue;  // Skip characters not in the string
            }

            if (f == maxFreqValue) {
                maxFreqCounter++;  // If frequency matches max, increment counter
            }

            if (f == minFreqValue) {
                minFreqCounter++;  // If frequency matches min, increment counter
            }

            if (f > maxFreqValue) {
                maxFreqValue   = f;    // Update max frequency
                maxFreqCounter = 1;    // Reset counter for new max
            }

            if (f < minFreqValue) {
                minFreqValue   = f;    // Update min frequency
                minFreqCounter = 1;    // Reset counter for new min
            }
        }

        // Case 1: All characters already have the same frequency
        if ((maxFreqValue - minFreqValue) == 0) {
            return true;
        }
        // Case 2 (Case A or Case B): Only one character has frequency off by 1, or there’s a single char with freq 1
        else if ((maxFreqValue - minFreqValue) == 1 && (maxFreqCounter == 1 ||
                                                        (minFreqValue == 1 && minFreqCounter == 1))) {
            return true;
        }

        return false;  // Not possible by removing only one character
    }
}