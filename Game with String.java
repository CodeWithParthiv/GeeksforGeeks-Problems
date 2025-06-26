// Question: Game with String (medium)

// Given a string s consisting of lowercase alphabets and an integer k, your task is to find the minimum possible value of the string after removing exactly k characters.

// The value of the string is defined as the sum of the squares of the frequencies of each distinct character present in the string.

// Examples :

// Input: s = "abbccc", k = 2
// Output: 6
// Explaination: We remove two 'c' to get the value as 12 + 22 + 12 = 6 or We remove one 'b' and one 'c' to get the value 12 + 12 + 22 = 6.


// Input: s = "aaab", k = 2
// Output: 2
// Explaination: We remove two 'a'. Now we get the value as 12 + 12 = 2.


// Constraints:
// 0 ≤ k ≤ s.length() ≤ 10^5

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(n)

// Company Tags -> Amazon

// Topic Tags  -> Strings, Heap, Data Structures

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int minValue(String s, int k) {
        int[] freq = new int[26]; // Frequency array for 26 lowercase letters

        // Count frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Remove k characters greedily from the highest frequency char
        while (k-- > 0) {
            Arrays.sort(freq);   // Sort to bring max freq to end
            if (freq[25] == 0) { // If all characters are removed
                break;
            }
            freq[25]--; // Remove one occurrence from highest freq char
        }

        int result = 0;
        for (int val : freq) {
            result += val * val; // Sum of squares of remaining frequencies
        }

        return result;
    }
}